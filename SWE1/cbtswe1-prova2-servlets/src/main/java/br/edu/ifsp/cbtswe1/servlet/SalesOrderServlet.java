package br.edu.ifsp.cbtswe1.servlet;

import br.edu.ifsp.cbtswe1.dao.CustomerDao;
import br.edu.ifsp.cbtswe1.dao.SalesOrderDao;
import br.edu.ifsp.cbtswe1.dao.SalesmanDao;
import br.edu.ifsp.cbtswe1.model.SalesOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static br.edu.ifsp.cbtswe1.servlet.ServletUtil.databaseMessage;
import static br.edu.ifsp.cbtswe1.servlet.ServletUtil.date;
import static br.edu.ifsp.cbtswe1.servlet.ServletUtil.decimal;
import static br.edu.ifsp.cbtswe1.servlet.ServletUtil.integer;

@WebServlet("/orders")
public class SalesOrderServlet extends HttpServlet {
    private final SalesOrderDao salesOrderDao = new SalesOrderDao();
    private final CustomerDao customerDao = new CustomerDao();
    private final SalesmanDao salesmanDao = new SalesmanDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("new".equals(action)) {
                showForm(request, response, new SalesOrder(), false);
            } else if ("edit".equals(action)) {
                SalesOrder order = salesOrderDao.findById(integer(request, "id", "Codigo", 1, 99999));
                if (order == null) {
                    list(request, response, "Ordem de venda nao encontrada.", null);
                    return;
                }
                showForm(request, response, order, true);
            } else {
                list(request, response, null, successMessage(request));
            }
        } catch (SQLException exception) {
            throw new ServletException(exception);
        } catch (IllegalArgumentException exception) {
            list(request, response, exception.getMessage(), null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        try {
            if ("delete".equals(action)) {
                salesOrderDao.delete(integer(request, "id", "Codigo", 1, 99999));
                response.sendRedirect(request.getContextPath() + "/orders?deleted=1");
                return;
            }

            SalesOrder order = parse(request);
            boolean editing = Boolean.parseBoolean(request.getParameter("editing"));

            if (editing) {
                salesOrderDao.update(order);
            } else {
                salesOrderDao.insert(order);
            }

            response.sendRedirect(request.getContextPath() + "/orders?saved=1");
        } catch (IllegalArgumentException exception) {
            request.setAttribute("error", exception.getMessage());
            showForm(request, response, parseLenient(request), Boolean.parseBoolean(request.getParameter("editing")));
        } catch (SQLException exception) {
            if ("delete".equals(action)) {
                list(request, response, databaseMessage(exception, "excluir a ordem"), null);
            } else {
                request.setAttribute("error", databaseMessage(exception, "salvar a ordem"));
                showForm(request, response, parseLenient(request), Boolean.parseBoolean(request.getParameter("editing")));
            }
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response, String error, String success)
            throws ServletException, IOException {
        try {
            request.setAttribute("activePage", "orders");
            request.setAttribute("orders", salesOrderDao.findAll());
            request.setAttribute("error", error);
            request.setAttribute("success", success);
            request.getRequestDispatcher("/WEB-INF/views/orders/list.jsp").forward(request, response);
        } catch (SQLException exception) {
            throw new ServletException(exception);
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, SalesOrder order, boolean editing)
            throws ServletException, IOException {
        try {
            request.setAttribute("activePage", "orders");
            request.setAttribute("order", order);
            request.setAttribute("customers", customerDao.findAll());
            request.setAttribute("salesmen", salesmanDao.findAll());
            request.setAttribute("editing", editing);
            request.getRequestDispatcher("/WEB-INF/views/orders/form.jsp").forward(request, response);
        } catch (SQLException exception) {
            throw new ServletException(exception);
        }
    }

    private SalesOrder parse(HttpServletRequest request) {
        return new SalesOrder(
                integer(request, "ordNo", "Numero da ordem", 1, 99999),
                decimal(request, "purchAmt", "Valor"),
                date(request, "ordDate", "Data"),
                integer(request, "customerId", "Cliente", 1, 99999),
                integer(request, "salesmanId", "Vendedor", 1, 99999)
        );
    }

    private SalesOrder parseLenient(HttpServletRequest request) {
        SalesOrder order = new SalesOrder();
        try {
            order.setOrdNo(Integer.parseInt(request.getParameter("ordNo")));
        } catch (RuntimeException ignored) {
            order.setOrdNo(0);
        }
        try {
            order.setPurchAmt(decimal(request, "purchAmt", "Valor"));
        } catch (RuntimeException ignored) {
            order.setPurchAmt(null);
        }
        try {
            order.setOrdDate(date(request, "ordDate", "Data"));
        } catch (RuntimeException ignored) {
            order.setOrdDate(null);
        }
        try {
            order.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        } catch (RuntimeException ignored) {
            order.setCustomerId(0);
        }
        try {
            order.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));
        } catch (RuntimeException ignored) {
            order.setSalesmanId(0);
        }
        return order;
    }

    private String successMessage(HttpServletRequest request) {
        if ("1".equals(request.getParameter("saved"))) {
            return "Ordem salva com sucesso.";
        }
        if ("1".equals(request.getParameter("deleted"))) {
            return "Ordem excluida com sucesso.";
        }
        return null;
    }
}

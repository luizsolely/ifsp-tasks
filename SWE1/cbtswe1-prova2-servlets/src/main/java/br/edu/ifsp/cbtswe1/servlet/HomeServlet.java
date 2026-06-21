package br.edu.ifsp.cbtswe1.servlet;

import br.edu.ifsp.cbtswe1.dao.CustomerDao;
import br.edu.ifsp.cbtswe1.dao.SalesOrderDao;
import br.edu.ifsp.cbtswe1.dao.SalesmanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final SalesmanDao salesmanDao = new SalesmanDao();
    private final CustomerDao customerDao = new CustomerDao();
    private final SalesOrderDao salesOrderDao = new SalesOrderDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("activePage", "home");
            request.setAttribute("salesmanCount", salesmanDao.count());
            request.setAttribute("customerCount", customerDao.count());
            request.setAttribute("orderCount", salesOrderDao.count());
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } catch (SQLException exception) {
            throw new ServletException(exception);
        }
    }
}

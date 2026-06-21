package br.edu.ifsp.cbtswe1.dao;

import br.edu.ifsp.cbtswe1.model.SalesOrder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderDao {
    public List<SalesOrder> findAll() throws SQLException {
        String sql = "SELECT o.ord_no, o.purch_amt, o.ord_date, o.customer_id, o.salesman_id, "
                + "c.cust_name AS customer_name, s.name AS salesman_name "
                + "FROM orders o "
                + "INNER JOIN customer c ON c.customer_id = o.customer_id "
                + "INNER JOIN salesman s ON s.salesman_id = o.salesman_id "
                + "ORDER BY o.ord_date DESC, o.ord_no";
        List<SalesOrder> orders = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                orders.add(map(resultSet));
            }
        }

        return orders;
    }

    public SalesOrder findById(int id) throws SQLException {
        String sql = "SELECT o.ord_no, o.purch_amt, o.ord_date, o.customer_id, o.salesman_id, "
                + "c.cust_name AS customer_name, s.name AS salesman_name "
                + "FROM orders o "
                + "INNER JOIN customer c ON c.customer_id = o.customer_id "
                + "INNER JOIN salesman s ON s.salesman_id = o.salesman_id "
                + "WHERE o.ord_no = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        }
    }

    public void insert(SalesOrder order) throws SQLException {
        String sql = "INSERT INTO orders (ord_no, purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            fillStatement(statement, order);
            statement.executeUpdate();
        }
    }

    public void update(SalesOrder order) throws SQLException {
        String sql = "UPDATE orders SET purch_amt = ?, ord_date = ?, customer_id = ?, salesman_id = ? WHERE ord_no = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBigDecimal(1, order.getPurchAmt());
            statement.setDate(2, Date.valueOf(order.getOrdDate()));
            statement.setInt(3, order.getCustomerId());
            statement.setInt(4, order.getSalesmanId());
            statement.setInt(5, order.getOrdNo());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE ord_no = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public long count() throws SQLException {
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM orders")) {
            resultSet.next();
            return resultSet.getLong(1);
        }
    }

    private void fillStatement(PreparedStatement statement, SalesOrder order) throws SQLException {
        statement.setInt(1, order.getOrdNo());
        statement.setBigDecimal(2, order.getPurchAmt());
        statement.setDate(3, Date.valueOf(order.getOrdDate()));
        statement.setInt(4, order.getCustomerId());
        statement.setInt(5, order.getSalesmanId());
    }

    private SalesOrder map(ResultSet resultSet) throws SQLException {
        SalesOrder order = new SalesOrder();
        order.setOrdNo(resultSet.getInt("ord_no"));
        order.setPurchAmt(resultSet.getBigDecimal("purch_amt"));
        order.setOrdDate(resultSet.getDate("ord_date").toLocalDate());
        order.setCustomerId(resultSet.getInt("customer_id"));
        order.setSalesmanId(resultSet.getInt("salesman_id"));
        order.setCustomerName(resultSet.getString("customer_name"));
        order.setSalesmanName(resultSet.getString("salesman_name"));
        return order;
    }
}

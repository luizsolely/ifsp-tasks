package br.edu.ifsp.cbtswe1.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public final class Database {
    private static final String DEFAULT_URL = "jdbc:h2:file:./data/cbtswe1_prova2;MODE=LEGACY;DATABASE_TO_UPPER=false";
    private static final String DEFAULT_USER = "sa";
    private static final String DEFAULT_PASSWORD = "";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException exception) {
            throw new SQLException("Driver H2 nao encontrado.", exception);
        }

        String url = valueOrDefault(System.getenv("DB_URL"), DEFAULT_URL);
        String user = valueOrDefault(System.getenv("DB_USER"), DEFAULT_USER);
        String password = valueOrDefault(System.getenv("DB_PASSWORD"), DEFAULT_PASSWORD);
        return DriverManager.getConnection(url, user, password);
    }

    public static void initialize() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS salesman ("
                    + "salesman_id NUMERIC(5) PRIMARY KEY,"
                    + "name VARCHAR(30) NOT NULL,"
                    + "city VARCHAR(15) NOT NULL,"
                    + "commission DECIMAL(5,2) NOT NULL,"
                    + "CONSTRAINT ck_salesman_id CHECK (salesman_id BETWEEN 1 AND 99999),"
                    + "CONSTRAINT ck_salesman_commission CHECK (commission >= 0)"
                    + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS customer ("
                    + "customer_id NUMERIC(5) PRIMARY KEY,"
                    + "cust_name VARCHAR(30) NOT NULL,"
                    + "city VARCHAR(15) NOT NULL,"
                    + "grade NUMERIC(3) NOT NULL,"
                    + "salesman_id NUMERIC(5) NOT NULL,"
                    + "CONSTRAINT ck_customer_id CHECK (customer_id BETWEEN 1 AND 99999),"
                    + "CONSTRAINT ck_customer_grade CHECK (grade BETWEEN 0 AND 999),"
                    + "CONSTRAINT fk_customer_salesman FOREIGN KEY (salesman_id) REFERENCES salesman (salesman_id)"
                    + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS orders ("
                    + "ord_no NUMERIC(5) PRIMARY KEY,"
                    + "purch_amt DECIMAL(8,2) NOT NULL,"
                    + "ord_date DATE NOT NULL,"
                    + "customer_id NUMERIC(5) NOT NULL,"
                    + "salesman_id NUMERIC(5) NOT NULL,"
                    + "CONSTRAINT ck_order_no CHECK (ord_no BETWEEN 1 AND 99999),"
                    + "CONSTRAINT ck_order_amount CHECK (purch_amt >= 0),"
                    + "CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id),"
                    + "CONSTRAINT fk_order_salesman FOREIGN KEY (salesman_id) REFERENCES salesman (salesman_id)"
                    + ")");

            seed(connection);
        } catch (SQLException exception) {
            throw new IllegalStateException("Nao foi possivel preparar o banco de dados.", exception);
        }
    }

    private static void seed(Connection connection) throws SQLException {
        if (count(connection, "salesman") > 0) {
            return;
        }

        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO salesman (salesman_id, name, city, commission) VALUES (?, ?, ?, ?)")) {
            insertSalesman(statement, 5001, "James Hoog", "New York", "0.15");
            insertSalesman(statement, 5002, "Nail Knite", "Paris", "0.13");
            insertSalesman(statement, 5005, "Pit Alex", "London", "0.11");
            insertSalesman(statement, 5006, "Mc Lyon", "Paris", "0.14");
            insertSalesman(statement, 5007, "Paul Adam", "Rome", "0.13");
            insertSalesman(statement, 5003, "Lauson Hen", "San Jose", "0.12");
        }

        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO customer (customer_id, cust_name, city, grade, salesman_id) VALUES (?, ?, ?, ?, ?)")) {
            insertCustomer(statement, 3002, "Nick Rimando", "New York", 100, 5001);
            insertCustomer(statement, 3005, "Graham Zusi", "California", 200, 5002);
            insertCustomer(statement, 3001, "Brad Guzan", "London", 100, 5005);
            insertCustomer(statement, 3004, "Fabian Johns", "Paris", 300, 5006);
            insertCustomer(statement, 3007, "Brad Davis", "New York", 200, 5001);
        }

        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO orders (ord_no, purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?, ?)")) {
            insertOrder(statement, 70001, "150.50", LocalDate.of(2026, 6, 10), 3005, 5002);
            insertOrder(statement, 70002, "270.65", LocalDate.of(2026, 6, 12), 3001, 5005);
            insertOrder(statement, 70003, "65.26", LocalDate.of(2026, 6, 14), 3002, 5001);
        }
    }

    private static long count(Connection connection, String table) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + table)) {
            resultSet.next();
            return resultSet.getLong(1);
        }
    }

    private static void insertSalesman(PreparedStatement statement, int id, String name, String city, String commission)
            throws SQLException {
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, city);
        statement.setBigDecimal(4, new BigDecimal(commission));
        statement.executeUpdate();
    }

    private static void insertCustomer(PreparedStatement statement, int id, String name, String city, int grade,
                                       int salesmanId) throws SQLException {
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, city);
        statement.setInt(4, grade);
        statement.setInt(5, salesmanId);
        statement.executeUpdate();
    }

    private static void insertOrder(PreparedStatement statement, int id, String amount, LocalDate date, int customerId,
                                    int salesmanId) throws SQLException {
        statement.setInt(1, id);
        statement.setBigDecimal(2, new BigDecimal(amount));
        statement.setDate(3, Date.valueOf(date));
        statement.setInt(4, customerId);
        statement.setInt(5, salesmanId);
        statement.executeUpdate();
    }

    private static String valueOrDefault(String value, String fallback) {
        return value == null || value.trim().isEmpty() ? fallback : value;
    }
}

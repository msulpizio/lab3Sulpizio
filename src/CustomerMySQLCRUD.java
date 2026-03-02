import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySQLCRUD {

    // Must match your Workbench database name EXACTLY:
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Store";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void insertCustomer(Connection connection, Customer c) throws SQLException {
        String sql = "INSERT INTO Customers (firstName, lastName, age, email, phone, address, membership) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setInt(3, c.getAge());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPhone());
            ps.setString(6, c.getAddress());
            ps.setString(7, c.getMembership());
            ps.executeUpdate();
        }
    }

    public static List<Customer> getAllCustomers(Connection connection) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, firstName, lastName, age, email, phone, address, membership FROM Customers";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("membership")
                ));
            }
        }
        return customers;
    }

    public static void updateCustomerFirstName(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE Customers SET firstName = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newFirstName);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public static void deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Customers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
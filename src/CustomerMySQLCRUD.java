
/** Project: Lab 3
 * Purpose Details: Customer CRUD
 * Course: IST 242
 * Author: Matthew Sulpizio
 * Date Developed: 2/20/26
 * Last Date Changed: 3/1/26
 * Rev:

 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides CRUD operations for Customer data stored in MySQL.
 */
public class CustomerMySQLCRUD {

    /**
     * Creates a CustomerMySQLCRUD object.
     */
    public CustomerMySQLCRUD() {
    }

    /** Connection URL for the MySQL database. */
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Store";
    /** MySQL username. */
    private static final String USERNAME = "root";
    /** MySQL password. */
    private static final String PASSWORD = "IST888IST888";

    /**
     * Creates and returns a Connection to the MySQL database.
     *
     * @return A Connection to the database.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    /**
     * Inserts a Customer into the Customers table.
     *
     * @param connection Active connection.
     * @param c The Customer to insert.
     * @throws SQLException If the insert fails.
     */
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

    /**
     * Reads all customers from the Customers table.
     *
     * @param connection Active connection.
     * @return A List of all customers in the table.
     * @throws SQLException If the query fails.
     */
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

    /**
     * Updates the first name of a customer by id.
     *
     * @param connection Active connection.
     * @param id The id of the customer to update.
     * @param newFirstName The new first name value.
     * @throws SQLException If the update fails.
     */
    public static void updateCustomerFirstName(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE Customers SET firstName = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newFirstName);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    /**
     * Deletes a customer by id.
     *
     * @param connection Active connection.
     * @param id The id of the customer to delete.
     * @throws SQLException If the delete fails.
     */
    public static void deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Customers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
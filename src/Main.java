import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Bob", "Johnson", 37, "bobjohnson37@gmail.com", "2156079823", "10967 Woodland Road", "Gold");
        Customer c2 = new Customer(2, "Alice", "Smith", 28, "alice.smith@gmail.com", "6095551212", "22 Main Street", "Silver");
        Customer c3 = new Customer(3, "Matt", "Sulpizio", 21, "matt.sulpizio@gmail.com", "8565557788", "1 College Ave", "Platinum");

        // -------------------------
        // MySQL CRUD
        // -------------------------
        try (Connection conn = CustomerMySQLCRUD.getConnection()) {

            System.out.println("=== MYSQL: INSERT 3 CUSTOMERS ===");
            CustomerMySQLCRUD.insertCustomer(conn, c1);
            CustomerMySQLCRUD.insertCustomer(conn, c2);
            CustomerMySQLCRUD.insertCustomer(conn, c3);

            System.out.println("=== MYSQL: READ ALL ===");
            List<Customer> mysqlCustomers = CustomerMySQLCRUD.getAllCustomers(conn);
            mysqlCustomers.forEach(System.out::println);

            System.out.println("=== MYSQL: UPDATE (id=1) FIRST NAME ===");
            CustomerMySQLCRUD.updateCustomerFirstName(conn, 1, "UpdatedBob");

            System.out.println("=== MYSQL: READ ALL AGAIN ===");
            CustomerMySQLCRUD.getAllCustomers(conn).forEach(System.out::println);

            System.out.println("=== MYSQL: DELETE (id=2) ===");
            CustomerMySQLCRUD.deleteCustomer(conn, 2);

            System.out.println("=== MYSQL: READ ALL AFTER DELETE ===");
            CustomerMySQLCRUD.getAllCustomers(conn).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("MYSQL ERROR:");
            e.printStackTrace();
        }

        // -------------------------
        // MongoDB CRUD
        // -------------------------
        try {
            MongoCollection<Document> collection = CustomerMongoCRUD.getCollection();

            System.out.println("\n=== MONGO: INSERT 3 CUSTOMERS ===");
            CustomerMongoCRUD.insertCustomer(collection, c1);
            CustomerMongoCRUD.insertCustomer(collection, c2);
            CustomerMongoCRUD.insertCustomer(collection, c3);

            System.out.println("=== MONGO: READ ALL ===");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

            System.out.println("=== MONGO: UPDATE (id=1) FIRST NAME ===");
            CustomerMongoCRUD.updateCustomerFirstName(collection, 1, "UpdatedBob");

            System.out.println("=== MONGO: READ ALL AGAIN ===");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

            System.out.println("=== MONGO: DELETE (id=2) ===");
            CustomerMongoCRUD.deleteCustomer(collection, 2);

            System.out.println("=== MONGO: READ ALL AFTER DELETE ===");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

        } catch (Exception e) {
            System.out.println("MONGO ERROR:");
            e.printStackTrace();
        }
    }
}
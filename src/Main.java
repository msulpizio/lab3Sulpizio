
/** Project: Lab 3
 * Purpose Details: Customer CRUD
 * Course: IST 242
 * Author: Matthew Sulpizio
 * Date Developed: 2/20/26
 * Last Date Changed: 3/1/26
 * Rev:

 */


import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Connection;
import java.util.List;

/**
 * Program entry point for demonstrating Customer CRUD operations in
 * both MySQL and MongoDB.
 */
public class Main {

    /**
     * Prevents instantiation of the Main class.
     */
    private Main() {
    }

    /**
     * Runs the program and demonstrates insert, read, update, and delete
     * for customers in both MySQL and MongoDB.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Bob", "Johnson", 37, "bjohnson37@gmail.com", "2156079823", "10967 Woodland Road", "Gold");
        Customer c2 = new Customer(2, "Tyler", "Robinson", 49, "trobinson49@gmail.com", "3420978475", "64918 Rydal Ave", "Silver");
        Customer c3 = new Customer(3, "Kevin", "Braxton", 26, "kbraxton26@gmail.com", "4397162078", "34571 Stoneridge Street", "Platinum");
        Customer c4 = new Customer(4, "Roger", "Smith", 53, "rsmith53@gmail.com", "3027863192", "86321 Philadelphia Ave", "Gold");
        Customer c5 = new Customer(5, "Jeremy", "Thompson", 64, "bthompson64@gmail.com", "8732091365", "30296 Brickhouse Road", "Silver");
        Customer c6 = new Customer(6, "Mike", "Jeferson", 42, "mjefferson42@gmail.com", "7609831287", "80934 River Street", "Platinum");

        /**
         * MYSQL CRUD
         */
        try (Connection conn = CustomerMySQLCRUD.getConnection()) {

            System.out.println("--- MYSQL: INSERT CUSTOMERS ---");
            CustomerMySQLCRUD.insertCustomer(conn, c1);
            CustomerMySQLCRUD.insertCustomer(conn, c2);
            CustomerMySQLCRUD.insertCustomer(conn, c3);
            CustomerMySQLCRUD.insertCustomer(conn, c4);
            CustomerMySQLCRUD.insertCustomer(conn, c5);
            CustomerMySQLCRUD.insertCustomer(conn, c6);

            System.out.println("--- MYSQL: READ ALL ---");
            List<Customer> mysqlCustomers = CustomerMySQLCRUD.getAllCustomers(conn);
            mysqlCustomers.forEach(System.out::println);

            System.out.println("--- MYSQL: UPDATE (id=1) FIRST NAME ---");
            CustomerMySQLCRUD.updateCustomerFirstName(conn, 1, "Brian");

            System.out.println("--- MYSQL: READ ALL AGAIN ---");
            CustomerMySQLCRUD.getAllCustomers(conn).forEach(System.out::println);

            System.out.println("--- MYSQL: DELETE (id=2) ---");
            CustomerMySQLCRUD.deleteCustomer(conn, 2);

            System.out.println("--- MYSQL: READ ALL AFTER DELETE ===");
            CustomerMySQLCRUD.getAllCustomers(conn).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("MYSQL ERROR:");
            e.printStackTrace();
        }

        /**
         * MongoDB CRUD
         */
        try {
            MongoCollection<Document> collection = CustomerMongoCRUD.getCollection();

            System.out.println("\n--- MONGO: INSERT CUSTOMERS ---");
            CustomerMongoCRUD.insertCustomer(collection, c1);
            CustomerMongoCRUD.insertCustomer(collection, c2);
            CustomerMongoCRUD.insertCustomer(collection, c3);
            CustomerMongoCRUD.insertCustomer(collection, c4);
            CustomerMongoCRUD.insertCustomer(collection, c5);
            CustomerMongoCRUD.insertCustomer(collection, c6);


            System.out.println("--- MONGO: READ ALL ---");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

            System.out.println("--- MONGO: UPDATE (id=1) FIRST NAME ---");
            CustomerMongoCRUD.updateCustomerFirstName(collection, 1, "Brian");

            System.out.println("--- MONGO: READ ALL AGAIN ---");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

            System.out.println("--- MONGO: DELETE (id=2) ---");
            CustomerMongoCRUD.deleteCustomer(collection, 2);

            System.out.println("--- MONGO: READ ALL AFTER DELETE ---");
            CustomerMongoCRUD.getAllCustomers(collection).forEach(d -> System.out.println(d.toJson()));

        } catch (Exception e) {
            System.out.println("MONGO ERROR:");
            e.printStackTrace();
        }
    }
}
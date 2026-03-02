
/** Project: Lab 3
 * Purpose Details: Customer CRUD
 * Course: IST 242
 * Author: Matthew Sulpizio
 * Date Developed: 2/20/26
 * Last Date Changed: 3/1/26
 * Rev:

 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * Provides CRUD operations for Customer data stored in MongoDB.
 */
public class CustomerMongoCRUD {

    /**
     * Creates a CustomerMongoCRUD object.
     */
    public CustomerMongoCRUD() {
    }

    /** MongoDB connection string. */
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    /** MongoDB database name. */
    private static final String DB_NAME = "Store";
    /** MongoDB collection name. */
    private static final String COLLECTION_NAME = "Customers";

    /**
     * Returns the MongoDB collection used for storing customers.
     *
     * @return MongoCollection of objects.
     */
    public static MongoCollection<Document> getCollection() {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        MongoDatabase db = client.getDatabase(DB_NAME);
        return db.getCollection(COLLECTION_NAME);
    }

    /**
     * Inserts a Customer's MongoDB information.
     *
     * @param collection The Mongo collection.
     * @param c The Customer to insert.
     */
    public static void insertCustomer(MongoCollection<Document> collection, Customer c) {
        Document doc = new Document("id", c.getId())
                .append("firstName", c.getFirstName())
                .append("lastName", c.getLastName())
                .append("age", c.getAge())
                .append("email", c.getEmail())
                .append("phone", c.getPhone())
                .append("address", c.getAddress())
                .append("membership", c.getMembership());

        collection.insertOne(doc);
    }

    /**
     * Reads all customer's MongoDB information.
     *
     * @param collection The Mongo collection.
     * @return A List of customer's information.
     */
    public static List<Document> getAllCustomers(MongoCollection<Document> collection) {
        List<Document> docs = new ArrayList<>();
        for (Document d : collection.find()) {
            docs.add(d);
        }
        return docs;
    }

    /**
     * Updates a customer's first name by id.
     *
     * @param collection The Mongo collection.
     * @param id The customer id to update.
     * @param newFirstName The new first name value.
     */
    public static void updateCustomerFirstName(MongoCollection<Document> collection, int id, String newFirstName) {
        collection.updateOne(eq("id", id), set("firstName", newFirstName));
    }

    /**
     * Deletes a customer by id.
     *
     * @param collection The Mongo collection.
     * @param id The customer id to delete.
     */
    public static void deleteCustomer(MongoCollection<Document> collection, int id) {
        collection.deleteOne(eq("id", id));
    }
}
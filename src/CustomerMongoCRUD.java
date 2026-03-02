import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class CustomerMongoCRUD {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DB_NAME = "Store";
    private static final String COLLECTION_NAME = "Customers";

    public static MongoCollection<Document> getCollection() {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        MongoDatabase db = client.getDatabase(DB_NAME);
        return db.getCollection(COLLECTION_NAME);
        // NOTE: We are not closing the client here for simplicity in a lab.
        // In a real app you'd keep the client for the app lifetime and close it on shutdown.
    }

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

    public static List<Document> getAllCustomers(MongoCollection<Document> collection) {
        List<Document> docs = new ArrayList<>();
        for (Document d : collection.find()) {
            docs.add(d);
        }
        return docs;
    }

    public static void updateCustomerFirstName(MongoCollection<Document> collection, int id, String newFirstName) {
        collection.updateOne(eq("id", id), set("firstName", newFirstName));
    }

    public static void deleteCustomer(MongoCollection<Document> collection, int id) {
        collection.deleteOne(eq("id", id));
    }
}
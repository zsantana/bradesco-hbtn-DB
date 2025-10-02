
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    public static MongoCollection<Document> getUsuarioCollection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017); // Ajuste se necessário
        MongoDatabase database = mongoClient.getDatabase("test_db");    // Use seu nome de banco
        return database.getCollection("usuarios");
    }
}
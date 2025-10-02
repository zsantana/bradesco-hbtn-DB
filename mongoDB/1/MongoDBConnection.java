
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    public static MongoCollection<Document> getUsuarioCollection() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017); // Ajuste se necessário
            MongoDatabase database = mongoClient.getDatabase("test_db");    // Use seu nome de banco
            System.out.println("Conexão estabelecida com sucesso ao MongoDB!");
            return database.getCollection("usuarios");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
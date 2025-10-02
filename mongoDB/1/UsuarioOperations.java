
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.Arrays;

public class UsuarioOperations {
    public static void main(String[] args) {
        MongoCollection<Document> collection = MongoDBConnection.getUsuarioCollection();

        // Limpa a coleção para evitar duplicados em execuções repetidas durante testes
        collection.deleteMany(new Document());

        // 1. Insira 3 registros
        Usuario u1 = new Usuario("Alice", 25);
        Usuario u2 = new Usuario("Bob", 30);
        Usuario u3 = new Usuario("Charlie", 35);

        collection.insertMany(Arrays.asList(u1.toDocument(), u2.toDocument(), u3.toDocument()));

        // 2. Consulte os registros
        System.out.println("== Usuários após inserção ==");
        printCollection(collection);

        // 3. Altere a idade de Bob para 32 anos
        collection.updateOne(
                Filters.eq("nome", "Bob"),
                new Document("$set", new Document("idade", 32))
        );

        // 4. Consulte os registros
        System.out.println("\n== Usuários após alteração de Bob ==");
        printCollection(collection);

        // 5. Apague o registro Charlie
        collection.deleteOne(Filters.eq("nome", "Charlie"));

        // 6. Consulte os registros
        System.out.println("\n== Usuários após exclusão de Charlie ==");
        printCollection(collection);
    }

    // Método auxiliar para listar todos os usuários
    public static void printCollection(MongoCollection<Document> collection) {
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Usuario usuario = Usuario.fromDocument(cursor.next());
                System.out.println(usuario);
            }
        }
    }
}
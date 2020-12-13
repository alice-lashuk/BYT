import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionFactoryImp implements ConnectionFactory {
    @Override
    public URLConnection createConnection(String urlString) {
        URLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

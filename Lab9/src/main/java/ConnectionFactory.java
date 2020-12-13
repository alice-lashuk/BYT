import java.net.URLConnection;

public interface ConnectionFactory {
    URLConnection createConnection(String url);
}

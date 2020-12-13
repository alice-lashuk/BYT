import java.net.URLConnection;

public class ConnectionFactoryStaticImpl implements ConnectionFactory {
    private URLConnection connection;

    public ConnectionFactoryStaticImpl(URLConnection connection) {
        this.connection = connection;
    }

    @Override
    public URLConnection createConnection(String url) {
        return connection;
    }
}

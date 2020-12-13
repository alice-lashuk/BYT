import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UrlInfo implements Serializable {
    private transient URLConnection connection;
    private Date lastModified;
    private List<UrlObserver> urlObservers = new ArrayList<>();

    public UrlInfo(URLConnection connection) {
        this(connection, new Date(0));
    }

    public UrlInfo(URLConnection connection, Date lastDateModified) {
        this.connection = connection;
        this.lastModified = lastDateModified;
    }


    public void addObserver(UrlObserver urlObserver) {
        urlObservers.add(urlObserver);
    }

    public void setLastModified(Date lastDateModified) {
        this.lastModified = lastDateModified;
    }

    public List<UrlObserver> getUrlObservers() {
        return urlObservers;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public Date fetchLastModified() {
        return new Date(connection.getLastModified());
    }

    public URLConnection getConnection() {
        return connection;
    }

    public void setConnection(URLConnection connection) {
        this.connection = connection;
    }
}

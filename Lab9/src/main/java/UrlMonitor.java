import java.net.URLConnection;
import java.util.*;

public class UrlMonitor implements Runnable {
    private MonitorState state;
    private ConnectionFactory factory;
    private long runIntervalMs;

    public UrlMonitor(ConnectionFactory factory, long runIntervalMs) {
        this.factory = factory;
        this.runIntervalMs = runIntervalMs;
        this.state = new MonitorState();
    }

    public void registerObserver(String url, UrlObserver urlObserver) {
        UrlInfo urlInfo = getState().getUrlInfo(url);
        if (urlInfo == null) {
            urlInfo = new UrlInfo(
                getFactory().createConnection(url)
            );
            getState().setUrlInfo(url, urlInfo);
        }
        urlInfo.addObserver(urlObserver);
    }

    @Override
    public void run() {
        while (true) {
            runOnce();
            try {
                Thread.sleep(runIntervalMs);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void saveState() {
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.writeToFile(getState());
    }

    public void restoreState() {
        FileProcessor fileProcessor = new FileProcessor();
        setState(fileProcessor.readFromFile());
        restoreConnections();
    }

    public void runOnce() {
        getState().getUrlInfoMap().forEach((url, urlInfo) -> {
            Date lastModified = urlInfo.getLastModified();
            Date newLastModified = urlInfo.fetchLastModified();

            if (newLastModified.compareTo(lastModified) > 0) {
                urlInfo.setLastModified(newLastModified);
                for (UrlObserver urlObserver : urlInfo.getUrlObservers()) {
                    urlObserver.update(url, newLastModified.toString());
                }
            }
        });
    }

    private void restoreConnections() {
        state.getUrlInfoMap().forEach((url, urlInfo) -> {
            URLConnection connection = getFactory().createConnection(url);
            urlInfo.setConnection(connection);
        });
    }

    private MonitorState getState() {
        return state;
    }

    private ConnectionFactory getFactory() {
        return factory;
    }

    private void setState(MonitorState state) {
        this.state = state;
    }

}

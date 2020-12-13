import java.io.Serializable;
import java.util.HashMap;

public class MonitorState implements Serializable {
    private HashMap<String, UrlInfo> urlInfoMap;

    public MonitorState() {
        urlInfoMap = new HashMap<>();
    }

    public void setUrlInfo(String url, UrlInfo urlInfo) {
        urlInfoMap.put(url, urlInfo);
    }

    public UrlInfo getUrlInfo(String url) {
        return urlInfoMap.get(url);
    }

    public HashMap<String, UrlInfo> getUrlInfoMap() {
        return urlInfoMap;
    }
}

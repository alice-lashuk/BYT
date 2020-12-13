import java.io.Serializable;

public class UrlObserverImpl implements UrlObserver, Serializable {
    private String name;

    public UrlObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String url, String date) {
        System.out.println("UrlObserver name: " + name + " URL: " + url + " Last modification: " + date);
    }
}

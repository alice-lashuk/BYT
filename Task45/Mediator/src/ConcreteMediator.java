import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    @Override
    public void send(Colleague colleague, String msg) {
        for(Colleague col : colleagues) {
            if(col != colleague) {
                col.receive(msg);
            }
        }
    }

    public void addColleagueToList(Colleague colleague) {
        colleagues.add(colleague);
    }
}

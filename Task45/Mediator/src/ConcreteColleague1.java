public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("I am a colleague 1. Received msg: " + msg);
    }
}

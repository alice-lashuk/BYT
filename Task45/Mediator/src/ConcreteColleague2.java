public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("I am a colleague 2. Received msg: " + msg);
    }
}

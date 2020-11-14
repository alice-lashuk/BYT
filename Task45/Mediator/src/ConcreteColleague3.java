public class ConcreteColleague3 extends Colleague {
    public ConcreteColleague3(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("I am a colleague 3. Received msg: " + msg);
    }
}

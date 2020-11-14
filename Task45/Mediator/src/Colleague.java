public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String msg);

    public void send(String msg) {
        mediator.send(this, msg);
    }
}

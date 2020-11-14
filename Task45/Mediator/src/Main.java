public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
        ConcreteColleague3 colleague3 = new ConcreteColleague3(mediator);

        mediator.addColleagueToList(colleague1);
        mediator.addColleagueToList(colleague2);
        mediator.addColleagueToList(colleague3);

        colleague1.send("Hello from colleague 1");

        System.out.println();

        colleague3.send("Hello from colleague 3");
    }
}

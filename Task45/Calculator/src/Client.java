public class Client {
    public static void main(String[] args) {
        Handler handler1 = new AdditionHandler();
        Handler handler2 = new DivisionHandler();
        Handler handler3 = new SubtractionHandler();
        Handler handler4 = new MultiplicationHandler();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);


        Request req1 = new Request("ADD", 4,5);
        Request req2 = new Request("TEST", 5,6);
        Request req3 = new Request("DIV", 5,6);
        Request req4 = new Request("MUL", 5,6);
        Request req5 = new Request("SUB", 5,6);

        handler1.solve(req2); // error
        handler1.solve(req1); // 9
        handler1.solve(req3); // ~ 0.83
        handler4.solve(req2); // error
        handler1.solve(req4); // 30
        handler1.solve(req5); // -1
    }
}

public class MultiplicationHandler implements Handler{
    private Handler nextHandler;
    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void solve(Request req) {
        if (req.getOperation().equals("MUL")) {
            double res = req.getNum1() * req.getNum2();
            System.out.println("result: " + res);
        } else if(req.getOperation().equals("ADD") || req.getOperation().equals("DIV") || req.getOperation().equals("SUB") ) {
            nextHandler.solve(req);
        } else {
            System.out.println("result: Error");
        }
    }
}

public class Request {
    private String operation;
    private double num1;
    private double num2;

    public Request(String operation, double firstNumber, double secondNumber ) {
        this.operation = operation;
        num1 = firstNumber;
        num2 = secondNumber;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }
}

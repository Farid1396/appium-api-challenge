package utils;

public class Operation {
    private int a;
    private int b;
    private String operation;
    private int expected;

    public Operation() {
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getOperation() {
        return operation;
    }

    public int getExpected() {
        return expected;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }
}

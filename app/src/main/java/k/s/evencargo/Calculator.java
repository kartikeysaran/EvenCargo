package k.s.evencargo;

public class Calculator {
    private double curr;
    public Calculator() {
        this.curr = 0;
    }
    public void add(double n) {
        this.curr+=n;
    }
    public void subtract(double n) {
        this.curr-=n;
    }
    public void multiply(double n) {
        this.curr*=n;
    }
    public void division(double n) {
        this.curr/=n;
    }
    public double getResults() {
        return curr;
    }
    public void clear() {
        this.curr = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        calculator.calc(1);
        calculator.calc(1);

        Calculator cached = (Calculator) ProxyUtils.makeCached(calculator);
        cached.calc(1);
        cached.calc(2);
        cached.calc(1);
    }
}

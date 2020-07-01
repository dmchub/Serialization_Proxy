public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int arg){
        int result = arg * arg;
        System.out.println("Value " + result + " is calculated");
        return result;
    }
}

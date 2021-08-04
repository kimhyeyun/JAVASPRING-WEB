public class main {
    public static void main(String[] args) {
        System.out.println("hello JUnit");

        Calculator calculator = new Calculator(new KrwCalculator());

        // 기존 테스트 방식
        System.out.println(calculator.sum(10,10));

        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10,10));

    }
}

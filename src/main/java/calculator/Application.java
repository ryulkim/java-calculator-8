package calculator;

public class Application {
    public static void main(String[] args) {
        OutputView.printRequestMessage();
        int[] inputs = InputHandler.readInputNumbers();
        int result = Calculator.add(inputs);
        OutputView.printResult(result);
    }
}

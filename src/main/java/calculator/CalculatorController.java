package calculator;

public class CalculatorController {
    public static void run() {
        OutputView.printRequestMessage();
        int[] inputs = InputHandler.readInputNumbers();
        int result = Calculator.add(inputs);
        OutputView.printResult(result);
    }
}

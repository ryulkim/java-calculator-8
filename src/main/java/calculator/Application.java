package calculator;

public class Application {
    public static void main(String[] args) {
        int[] inputs = InputHandler.readInputNumbers();
        int result = Calculator.add(inputs);
    }
}

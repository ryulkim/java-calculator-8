package calculator;

public class Calculator {
    public static int add(int[] inputs) {
        int sum = 0;
        for (int input : inputs) {
            sum += input;
        }
        return sum;
    }
}

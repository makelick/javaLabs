import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PerfectNumberFinderLambda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        do {
            System.out.print("Enter a positive integer (to exit enter an empty line): ");
            input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                if (number < 1) {
                    throw new NumberFormatException();
                }
                ArrayList<Integer> perfectNumbers = findPerfectNumbers(number);
                System.out.println("Perfect numbers between 1 and " + number + ": " + perfectNumbers);
            } catch (NumberFormatException e) {
                if (!input.isEmpty()) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        } while (!input.isEmpty());

        System.out.println("Exiting the application...");
        scanner.close();
    }

    private static ArrayList<Integer> findPerfectNumbers(int upperBound) {
        ArrayList<Integer> perfectNumbers = new ArrayList<>();
        IntPredicate isDivisor = (divisor) -> upperBound % divisor == 0;

        for (int num = 1; num <= upperBound; num++) {
            int sum;
            sum = IntStream.range(1, num).filter(isDivisor).sum();

            if (sum == num) {
                perfectNumbers.add(num);
            }
        }

        return perfectNumbers;
    }
}

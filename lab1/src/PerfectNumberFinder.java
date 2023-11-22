import java.util.ArrayList;
import java.util.Scanner;

public class PerfectNumberFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        do {
            System.out.print("Enter a positive integer (to exit enter an empty line): ");
            input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                if (number < 1) throw new NumberFormatException();
                ArrayList<Integer> perfectNumbers = findPerfectNumbers(number);
                System.out.println("Perfect numbers between 1 and " + number + ": " + perfectNumbers);
            } catch (NumberFormatException e) {
                if (!input.isEmpty())
                    System.out.println("Invalid input. Please enter a valid integer.");
            }

        } while (!input.isEmpty());

        System.out.println("Exiting the application...");
        scanner.close();
    }

    private static ArrayList<Integer> findPerfectNumbers(int upperBound) {
        ArrayList<Integer> perfectNumbers = new ArrayList<>();

        for (int num = 1; num <= upperBound; num++) {
            int sum = 0;
            for (int divisor = 1; divisor < num; divisor++) {
                if (num % divisor == 0) {
                    sum += divisor;
                }
            }

            if (sum == num) {
                perfectNumbers.add(num);
            }
        }

        return perfectNumbers;
    }
}

import java.util.Scanner;

public class Main {

    static Translator translator = new Translator();
    static Scanner scanner = new Scanner(System.in);
    static boolean isStarted = true;

    public static void main(String[] args) {

        do {
            System.out.println("Choose option:");
            System.out.println("1. Adds word pairs");
            System.out.println("2. Translate phrase");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> fillDictionary();
                case 2 -> translatePhrase();
                case 3 -> isStarted = false;
                default -> System.out.println("Incorrect choice.");
            }
        } while (isStarted);
    }

    private static void translatePhrase() {
        scanner.nextLine();
        System.out.println("Enter an English phrase to translate:");
        String englishPhrase = scanner.nextLine();

        String translatedPhrase = translator.translatePhrase(englishPhrase);
        System.out.println("Translated phrase: " + translatedPhrase);
    }

    private static void fillDictionary() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter word pairs (English Ukrainian), type empty line to finish:");

        while (true) {
            input = scanner.nextLine();

            if (input.isEmpty()) {
                return;
            }

            String[] words = input.split("\\s+");

            if (words.length == 2) {
                translator.addWordPair(words[0], words[1]);
            } else {
                System.out.println("Invalid input. Please enter word pairs in the format 'English Ukrainian'.");
            }
        }
    }
}
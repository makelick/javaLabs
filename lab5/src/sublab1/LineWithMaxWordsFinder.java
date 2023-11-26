package sublab1;


import java.io.*;
import java.util.Scanner;

public class LineWithMaxWordsFinder {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the filename: ");
            String fileName = scanner.next();

            System.out.println("String with the maximum number of words: " + findMaxWordsString(fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findMaxWordsString(String filename) throws IOException {
        try (InputStream inputStream = new FileInputStream(filename)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            String maxWordsString = "";
            int maxWordsCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                if (words.length > maxWordsCount) {
                    maxWordsCount = words.length;
                    maxWordsString = line;
                }
            }

            return maxWordsString;
        }
    }
}

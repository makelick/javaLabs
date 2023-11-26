package sublab3;

import java.io.*;
import java.util.Scanner;

public class FileEncryptor {

    static final char key = ' ';
    static final String outputFile = "result.txt";

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the input filename: ");
            String fileName = scanner.next();
            System.out.println("1. Encrypt 2. Decrypt");
            int choice = scanner.nextInt();
            if (choice == 1) {
                encryptFile(fileName);
                System.out.print("Encrypted data saved to file: result.txt");
            } else if (choice == 2) {
                decryptFile(fileName);
                System.out.print("Decrypted data saved to file: result.txt");
            } else {
                System.out.println("Incorrect choice.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptFile(String inputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             FilterOutputStream filterOut = new FilterOutputStream(outputStream) {
                 @Override
                 public void write(int b) throws IOException {
                     super.write(b + key);
                 }
             }) {

            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                filterOut.write(byteRead);
            }
        }
    }

    public static void decryptFile(String inputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             FilterOutputStream filterOut = new FilterOutputStream(outputStream) {
                 @Override
                 public void write(int b) throws IOException {
                     super.write(b - key);
                 }
             }) {

            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                filterOut.write(byteRead);
            }
        }
    }
}

package view;

import controller.ShapeController;
import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Shape;
import model.entity.Triangle;

import java.util.Scanner;

public class ShapeView {

    private static final ShapeController shapeController = new ShapeController();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display DataSet");
            System.out.println("2. Calculate Total Area");
            System.out.println("3. Calculate Total Area by Shape Type");
            System.out.println("4. Sort DataSet by Area");
            System.out.println("5. Sort DataSet by Color");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printDataSet(shapeController.getDataSet());
                case 2 -> printTotalArea(shapeController.calculateTotalArea());
                case 3 -> {
                    System.out.print("Enter shape type (1 - Rectangle, 2 - Triangle, 3 - Circle): ");
                    int input = scanner.nextInt();

                    switch (input) {
                        case 1 ->
                                printTotalAreaByType(
                                        shapeController.calculateTotalAreaByType(Rectangle.class),
                                        "Rectangle"
                                );
                        case 2 ->
                                printTotalAreaByType(
                                        shapeController.calculateTotalAreaByType(Triangle.class),
                                        "Triangle"
                                );
                        case 3 ->
                                printTotalAreaByType(
                                        shapeController.calculateTotalAreaByType(Circle.class),
                                        "Circle"
                                );

                        default -> System.out.println("Incorrect type.");
                    }
                }
                case 4 -> printDataSet(shapeController.getSortedDataSetByArea());
                case 5 -> printDataSet(shapeController.getSortedDataSetByColor());
                case 6 -> {
                    System.out.println("Exiting application.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    public static void printDataSet(Shape[] dataSet) {
        for (Shape shape : dataSet) {
            System.out.println(shape);
        }
    }

    public static void printTotalArea(double totalArea) {
        System.out.println("Total area of all shapes: " + totalArea);
    }

    private static void printTotalAreaByType(double totalArea, String shapeType) {
        System.out.println("Total area of " + shapeType + " shapes: " + totalArea);
    }
}
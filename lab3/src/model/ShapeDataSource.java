package model;

import model.entity.Circle;
import model.entity.Rectangle;
import model.entity.Shape;
import model.entity.Triangle;

import java.util.Random;

public class ShapeDataSource {

    static int maxShapeLength = 10;

    public static Shape[] generateShapes(int shapesCount) {
        Shape[] shapes = new Shape[shapesCount];
        for (int i = 0; i < shapesCount; i++) {
            shapes[i] = getRandomShape();
        }
        return shapes;
    }

    private static Shape getRandomShape() {
        Random random = new Random();

        String color = getRandomColor();
        int shapeType = random.nextInt(3);
        return switch (shapeType) {
            case 0 -> new Circle(color, random.nextInt(maxShapeLength) + 1);
            case 1 -> new Rectangle(color, random.nextInt(maxShapeLength) + 1, random.nextInt(maxShapeLength) + 1);
            case 2 -> new Triangle(color, random.nextInt(maxShapeLength) + 1, random.nextInt(maxShapeLength) + 1);
            default -> null;
        };
    }

    private static String getRandomColor() {
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Orange"};
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}

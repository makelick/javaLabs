package model.entity;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String shapeColor, double length, double width) {
        super(shapeColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calcArea() {
        return length * width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    @Override
    public String toString() {
        return "Rectangle[" +
                "length=" + length +
                ", width=" + width +
                ", area=" + calcArea() +
                ", color=\"" + shapeColor + "\"]";
    }
}

package model;

class Circle extends Shape {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", area=" + calcArea() +
                ", color=\"" + shapeColor + "\"]";
    }
}

package model;

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }

    @Override
    public String toString() {
        return "Triangle[" +
                "base=" + base +
                ", height=" + height +
                ", area=" + calcArea() +
                ", color=\"" + shapeColor + "\"]";
    }
}

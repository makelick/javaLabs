package model.entity;

public abstract class Shape implements Drawable {
    protected String shapeColor;

    public String getShapeColor() {
        return shapeColor;
    }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Shape[color=\"" + shapeColor + "\"]";
    }
}

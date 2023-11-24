package controller;

import model.ShapeDataSource;
import model.entity.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeController {

    static int datasetSize = 10;
    private final Shape[] dataSet;

    public ShapeController() {
        this.dataSet = ShapeDataSource.generateShapes(datasetSize);
    }

    public Shape[] getDataSet() {
        return dataSet;
    }

    public double calculateTotalArea() {
        return Arrays.stream(dataSet).mapToDouble(Shape::calcArea).sum();
    }

    public double calculateTotalAreaByType(Class<? extends Shape> type) {
        return Arrays.stream(dataSet)
                .filter(shape -> shape.getClass() == type)
                .mapToDouble(Shape::calcArea)
                .sum();
    }

    public Shape[] getSortedDataSetByArea() {
        Shape[] sortedList = dataSet.clone();
        Arrays.sort(sortedList, Comparator.comparingDouble(Shape::calcArea));
        return sortedList;
    }

    public Shape[] getSortedDataSetByColor() {
        Shape[] sortedList = dataSet.clone();
        Arrays.sort(sortedList, Comparator.comparing(Shape::getShapeColor));
        return sortedList;
    }
}

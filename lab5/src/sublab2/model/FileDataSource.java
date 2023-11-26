package sublab2.model;

import sublab2.model.entity.Shape;
import java.io.*;

public class FileDataSource {

    public static void saveToFile(String fileName, Shape[] dataSet) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            stream.writeObject(dataSet);
            System.out.println("Data saved to file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + fileName);
            e.printStackTrace();
        }
    }

    public static Shape[] readFromFile(String fileName) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = stream.readObject();

            if (object instanceof Shape[] dataSet) {
                System.out.println("Data read from file: " + fileName);
                return dataSet;
            } else {
                System.out.println("Invalid data in file: " + fileName);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading data from file: " + fileName);
        }

        return null;
    }
}

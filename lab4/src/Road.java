import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<? extends Passenger>> carsInRoad = new ArrayList<>();

    public void addCarToRoad(Vehicle<? extends Passenger> car) {
        carsInRoad.add(car);
    }

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<? extends Passenger> car : carsInRoad) {
            if (car != null) {
                count += car.getOccupiedSeats();
            }
        }
        return count;
    }
}

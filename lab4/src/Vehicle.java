import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Passenger> {

    private final int maxSeats;
    private int occupiedSeats;
    private final List<T> passengers;

    Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.occupiedSeats = 0;
        this.passengers = new ArrayList<>();
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void boardPassenger(T passenger) throws Exception {
        if (occupiedSeats < maxSeats) {
            passengers.add(passenger);
            occupiedSeats++;
        } else {
            throw new Exception("All seats are occupied");
        }
    }

    public void disembarkPassenger(T passenger) throws Exception {
        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
            occupiedSeats--;
        } else {
            throw new Exception("Passenger not found in the vehicle");
        }
    }
}

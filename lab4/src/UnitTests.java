import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UnitTests {

    @Test
    public void testBus() {
        Bus<Passenger> bus = new Bus<>(4);
        Passenger passenger = new Passenger("John");
        Firefighter firefighter = new Firefighter("Alice");

        try {
            bus.boardPassenger(passenger);
            bus.boardPassenger(firefighter);
            assertEquals(2, bus.getOccupiedSeats());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testFireTruck() {
        FireTruck fireTruck = new FireTruck(2);
        Firefighter firefighter = new Firefighter("Alice");

        try {
            fireTruck.boardPassenger(firefighter);
            assertEquals(1, fireTruck.getOccupiedSeats());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testPoliceCar() {
        PoliceCar policeCar = new PoliceCar(3);
        Policeman policeman = new Policeman("Bob");

        try {
            policeCar.boardPassenger(policeman);
            assertEquals(1, policeCar.getOccupiedSeats());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }


    @Test
    public void testTaxiOverflow() {
        Taxi<Passenger> taxi = new Taxi<>(1);
        Passenger passenger = new Passenger("John");
        Firefighter firefighter = new Firefighter("Alice");

        try {
            taxi.boardPassenger(passenger);
            taxi.boardPassenger(firefighter);
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertEquals("All seats are occupied", e.getMessage());
        }
    }

    @Test
    public void testDisembark() {
        Taxi<Passenger> taxi = new Taxi<>(4);
        Passenger passenger1 = new Passenger("John");
        Passenger passenger2 = new Passenger("Alice");

        try {
            taxi.boardPassenger(passenger1);
            taxi.boardPassenger(passenger2);
            taxi.disembarkPassenger(passenger1);
            assertEquals(1, taxi.getOccupiedSeats());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testCountOfHumansOnRoad() {
        Road road = new Road();

        Taxi<Passenger> taxi = new Taxi<>(4);
        FireTruck fireTruck = new FireTruck(2);
        PoliceCar policeCar = new PoliceCar(3);

        try {
            taxi.boardPassenger(new Passenger("John"));
            taxi.boardPassenger(new Passenger("Alice"));

            fireTruck.boardPassenger(new Firefighter("Bob"));

            policeCar.boardPassenger(new Policeman("Charlie"));

            road.addCarToRoad(taxi);
            road.addCarToRoad(fireTruck);
            road.addCarToRoad(policeCar);

            int count = road.getCountOfHumans();
            assertEquals(4, count);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}

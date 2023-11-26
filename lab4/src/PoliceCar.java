public class PoliceCar extends Vehicle<Policeman> {
    PoliceCar(int maxSeats) {
        super(maxSeats);
    }

    @Override
    public void boardPassenger(Policeman passenger) throws Exception {
        super.boardPassenger(passenger);
    }
}
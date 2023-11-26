class FireTruck extends Vehicle<Firefighter> {
    FireTruck(int maxSeats) {
        super(maxSeats);
    }

    @Override
    public void boardPassenger(Firefighter passenger) throws Exception {
        super.boardPassenger(passenger);
    }
}

import java.util.Random;

class MonteCarloPiTask implements Runnable {
    private final long iterations;
    private long pointsInsideCircle;

    public MonteCarloPiTask(long iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        Random random = new Random();
        long pointsInside = 0;

        for (long i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double distance = x * x + y * y;

            if (distance <= 1) {
                pointsInside++;
            }
        }

        pointsInsideCircle = pointsInside;
    }

    public long getPointsInsideCircle() {
        return pointsInsideCircle;
    }
}

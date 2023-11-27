import java.util.Scanner;

public class ParallelMonteCarloPi {

    static long iterations = 1_000_000_000L;

    public static void main(String[] args) {
        System.out.println("Enter the number of threads:");
        Scanner scanner = new Scanner(System.in);
        int numThreads = scanner.nextInt();

        System.out.println("Calculating PI using Monte Carlo method with " + numThreads + " threads");
        System.out.println("Iterations: " + iterations);

        long startTime = System.currentTimeMillis();

        double pi = calculatePiParallel(iterations, numThreads);

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("PI is " + pi);
        System.out.println("THREADS " + numThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + totalTime + "ms");
    }

    private static double calculatePiParallel(long iterations, int numThreads) {
        long pointsInsideCircle = 0;

        Thread[] threads = new Thread[numThreads];
        MonteCarloPiTask[] tasks = new MonteCarloPiTask[numThreads];

        for (int i = 0; i < numThreads; i++) {
            tasks[i] = new MonteCarloPiTask(iterations / numThreads);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
                pointsInsideCircle += tasks[i].getPointsInsideCircle();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 4.0 * pointsInsideCircle / iterations;
    }
}

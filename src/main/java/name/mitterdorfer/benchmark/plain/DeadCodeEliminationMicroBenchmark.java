package name.mitterdorfer.benchmark.plain;

/**
 * This (flawed) microbenchmark demonstrates very clearly how compiler optimizations can render the benchmark ineffective.
 * In this case dead code elimination eliminates the whole benchmark code after a few invocations.
 */
public class DeadCodeEliminationMicroBenchmark {
    private static final int MAX_COUNT = 1_000_000_000;

    public static void main(String[] args) {
        doBenchmark(MAX_COUNT / 1_000_000);
        doBenchmark(MAX_COUNT / 1_000_000);
        doBenchmark(MAX_COUNT / 100_000);
        doBenchmark(MAX_COUNT / 10_000);
        doBenchmark(MAX_COUNT / 1_000);
        doBenchmark(MAX_COUNT / 100);
        doBenchmark(MAX_COUNT / 10);

        doBenchmark(MAX_COUNT);
        doBenchmark(MAX_COUNT);
        doBenchmark(MAX_COUNT);
    }

    private static void doBenchmark(int n) {
        long start = System.nanoTime();
        runBenchmark(n);
        long end = System.nanoTime();

        System.out.printf("Took %d ns%n", (end - start));
    }

    // This entire method is subject to constant folding, hoisting and ultimately dead code elimination.
    // Note how the measured time drops to zero after a few invocations.
    private static int runBenchmark(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = benchmarkedMethod();
            }
        }
        return result;
    }

    private static int benchmarkedMethod() {
        // use this to simulate some "real" work - the compiler will not eliminate
        // this call (at least not on OpenJDK 1.8.0-ea-b124)
        //return ((int) System.currentTimeMillis() % 10);

        // intentionally not much to do - we want to measure the runtime overhead of method calls
        return 3;
    }
}

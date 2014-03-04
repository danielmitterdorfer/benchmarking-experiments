package name.mitterdorfer.benchmark.plain;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class FlawedSetMicroBenchmark {
    private static final int MAX_ELEMENTS = 10_000_000;

    public static void main(String[] args) {
        List<? extends Set<Integer>> testees =
                Arrays.asList(
                        new HashSet<Integer>(),
                        new TreeSet<Integer>(),
                        new ConcurrentSkipListSet<Integer>());
        for (Set<Integer> testee : testees) {
            doBenchmark(testee);
        }

    }

    private static void doBenchmark(Set<Integer> testee) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            testee.add(i);
        }
        long end = System.currentTimeMillis();

        System.out.printf("%s took %d ms%n",
                testee.getClass(),
                (end - start));
    }
}

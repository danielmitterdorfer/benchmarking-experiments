package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * This microbenchmark measures the runtime overhead of the total system. It is based on JMHSample_01_HelloWorld from JMH.
 */
public class HelloJMHMicroBenchmark {
    @SuppressWarnings("unused") //invoked by benchmarking framework
    @Benchmark
    public void benchmarkRuntimeOverhead() {
        //intentionally left blank
    }
}

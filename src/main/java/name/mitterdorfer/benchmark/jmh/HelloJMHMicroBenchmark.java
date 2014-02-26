package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

/**
 * This microbenchmark measures the runtime overhead of the total system. It is based on JMHSample_01_HelloWorld from JMH.
 */
public class HelloJMHMicroBenchmark {
    @GenerateMicroBenchmark
    public void benchmarkRuntimeOverhead() {
        //intentionally left blank
    }
}

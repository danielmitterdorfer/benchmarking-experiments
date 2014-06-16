package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * This benchmark demonstrates how we can set specific options for microbenchmarks via annotations. These values can be
 * overridden via command line parameters.
 *
 * The microbenchmark performs the same measurement as HelloJMHMicroBenchmark.
 *
 * Produced output:
 *
 * Benchmark                                                 Mode   Samples         Mean   Mean error    Units
 * n.m.j.SettingsMicroBenchmark.benchmarkRuntimeOverhead    thrpt        45  2651974,009    38016,820   ops/ms
 * n.m.j.SettingsMicroBenchmark.benchmarkRuntimeOverhead     avgt        45        0,000        0,000    ms/op
 * n.m.j.SettingsMicroBenchmark.benchmarkRuntimeOverhead   sample  78785190        0,000        0,000    ms/op
 * n.m.j.SettingsMicroBenchmark.benchmarkRuntimeOverhead       ss        45        0,001        0,000       ms
 *
 */
@Fork(value = 3, warmups = 5)
@Measurement(iterations = 15, time = 5, timeUnit = TimeUnit.SECONDS)
//just for demonstration purposes, use specific modes in real microbenchmarks
@BenchmarkMode(value = Mode.All)
public class SettingsMicroBenchmark {
    @Benchmark
    public void benchmarkRuntimeOverhead() {
        //intentionally empty
    }
}

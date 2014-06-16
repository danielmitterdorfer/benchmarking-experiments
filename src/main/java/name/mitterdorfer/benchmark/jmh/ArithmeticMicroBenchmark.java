package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;

@State(Scope.Benchmark)
public class ArithmeticMicroBenchmark {
    // Don't just add both numbers in the method
    // or the benchmark is prone to constant folding
    private long a = 5;
    private long b = 10;

    //For consistency...
    private BigInteger ba = BigInteger.valueOf(a);
    private BigInteger bb = BigInteger.valueOf(b);

    // No need for loops, JMH will handle this...
    @Benchmark
    public long addPrimitives() {
        return a + b;
    }

    // No need for loops, JMH will handle this...
    @Benchmark
    public BigInteger addBigIntegers() {
        return ba.add(bb);
    }

    // Blackholes are used to consume data in a non-trivial way so the compiler is not able to eliminate the call
    // In this case a Blachole wouldn't be necessary; they are more suitable when multiple values need to be consumed
    // in a single microbenchmark method
    @Benchmark
    public void addWithBlackhole(Blackhole bh) {
        bh.consume(a + b);
    }

}

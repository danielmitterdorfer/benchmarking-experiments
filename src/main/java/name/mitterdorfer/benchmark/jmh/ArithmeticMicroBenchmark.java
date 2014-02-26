package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

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
    @GenerateMicroBenchmark
    public long addPrimitives() {
        return a + b;
    }

    // No need for loops, JMH will handle this...
    @GenerateMicroBenchmark
    public BigInteger addBigIntegers() {
        return ba.add(bb);
    }

    // Blackholes are used to consume data in a non-trivial way so the compiler is not able to eliminate the call
    // In this case a Blachole wouldn't be necessary; they are more suitable when multiple values need to be consumed
    // in a single microbenchmark method
    @GenerateMicroBenchmark
    public void addWithBlackhole(BlackHole bh) {
        bh.consume(a + b);
    }

}

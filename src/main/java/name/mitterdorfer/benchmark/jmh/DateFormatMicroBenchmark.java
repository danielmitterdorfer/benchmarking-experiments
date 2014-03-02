package name.mitterdorfer.benchmark.jmh;


import org.apache.commons.lang3.time.FastDateFormat;
import org.openjdk.jmh.annotations.*;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Simple DateFormat microbenchmark that compares the multithreaded performance of SimpleDateFormat and FastDateFormat.
 *
 * Build a shaded JAR first by issuing "gradle shadow", then run this microbenchmark with
 * java -jar build/distributions/benchmarking-experiments-0.1.0-shadow.jar "name.mitterdorfer.benchmark.jmh.DateFormat.*" -rf csv -rff dateformats.csv
 */
@Fork(5)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DateFormatMicroBenchmark {

    //We'll always use the same Date throughout the microbenchmark for formatting

    @State(Scope.Benchmark)
    public static class DateToFormat {
        final Date date = new Date();
    }

    // We need to bind SimpleDateFormat to a
    // thread, otherwise it is broken
    @State(Scope.Thread)
    public static class JdkDateFormatHolder {
        final Format format = DateFormat.
                getDateInstance(DateFormat.MEDIUM);

        public String format(Date d) {
            return format.format(d);
        }
    }

    @State(Scope.Benchmark)
    public static class SyncJdkDateFormatHolder {
        final Format format = DateFormat.
                getDateInstance(DateFormat.MEDIUM);

        public synchronized String format(Date d) {
            return format.format(d);
        }
    }


    //Already threadsafe
    @State(Scope.Benchmark)
    public static class CommonsDateFormatHolder {
        final Format format = FastDateFormat.
                getDateInstance(FastDateFormat.MEDIUM);

        public String format(Date d) {
            return format.format(d);
        }
    }

    @GenerateMicroBenchmark
    @Threads(1)
    public String measureJdkFormat_1(
            JdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(2)
    public String measureJdkFormat_2(
            JdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(4)
    public String measureJdkFormat_4(
            JdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(8)
    public String measureJdkFormat_8(
            JdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(1)
    public String measureSyncJdkFormat_1(
            SyncJdkDateFormatHolder df,
            DateToFormat date) {

        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(2)
    public String measureSyncJdkFormat_2(
            SyncJdkDateFormatHolder df,
            DateToFormat date) {

        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(4)
    public String measureSyncJdkFormat_4(
            SyncJdkDateFormatHolder df,
            DateToFormat date) {

        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(8)
    public String measureSyncJdkFormat_8(
            SyncJdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(1)
    public String measureCommonsFormat_1(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(2)
    public String measureCommonsFormat_2(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(4)
    public String measureCommonsFormat_4(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(8)
    public String measureCommonsFormat_8(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }
}

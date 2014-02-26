package name.mitterdorfer.benchmark.jmh;


import org.apache.commons.lang3.time.FastDateFormat;
import org.openjdk.jmh.annotations.*;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// ausgeführt mit java -jar build/distributions/benchmarking-experiments-0.1.0-shadow.jar "name.mitterdorfer.benchmark.jmh.DateForm*" -rf csv -rff dateformats.csv -i 10 -wi 10 -f 5
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class DateFormatMicroBenchmark {
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
    public void baseline() {
        //intentionally empty to measure
        // overhead by the framework
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
    @Threads(5)
    public String measureJdkFormat_5(
            JdkDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(10)
    public String measureJdkFormat_10(
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
    @Threads(5)
    public String measureSyncJdkFormat_5(
            SyncJdkDateFormatHolder df,
            DateToFormat date) {

        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(10)
    public String measureSyncJdkFormat_10(
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
    @Threads(5)
    public String measureCommonsFormat_5(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }

    @GenerateMicroBenchmark
    @Threads(10)
    public String measureCommonsFormat_10(
            CommonsDateFormatHolder df,
            DateToFormat date) {
        return df.format(date.date);
    }
}

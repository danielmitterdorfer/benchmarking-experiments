Benchmarking Experiments
========================

This project contains experiments with purposefully flawed hand-written microbenchmarks and microbenchmarks with the Java Microbenchmarking Harness [JMH](http://openjdk.java.net/projects/code-tools/jmh).

# Getting Started

## Prerequisites

The project requires at least JDK 7 and Gradle 1.8 or Maven 3.0.

## Installation

Installation with Gradle (recommended):

```
git clone https://github.com/danielmitterdorfer/benchmarking-experiments.git
cd benchmarking-experiments
gradle shadow #or: mvn clean package
java -jar build/distributions/benchmarking-experiments-0.1.0-shadow.jar
```

or alternatively with Maven:

```
git clone https://github.com/danielmitterdorfer/benchmarking-experiments.git
cd benchmarking-experiments
mvn clean package
java -jar target/benchmarking-experiments.jar
```
# License

'Benchmarking Experiments' is distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
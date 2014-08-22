Benchmarking Experiments
========================

This project contains experiments with purposefully flawed hand-written microbenchmarks and microbenchmarks using the Java Microbenchmarking Harness ([JMH](http://openjdk.java.net/projects/code-tools/jmh)).

# Getting Started

## Prerequisites

The project requires at least JDK 7 and Gradle 2.0 or Maven 3.0.

## Installation

Installation with Gradle (recommended):

```
git clone https://github.com/danielmitterdorfer/benchmarking-experiments.git
cd benchmarking-experiments
gradle shadow
java -jar build/libs/benchmarking-experiments-0.1.0-all.jar
```

or alternatively with Maven:

```
git clone https://github.com/danielmitterdorfer/benchmarking-experiments.git
cd benchmarking-experiments
mvn clean package
java -jar target/benchmarking-experiments.jar
```

The Gradle build file supports also IntelliJ IDEA project setup. Just issue `gradle idea` to create the project files.

# License

'Benchmarking Experiments' is distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
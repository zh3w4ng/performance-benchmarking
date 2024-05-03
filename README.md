# Performance Bencharking 
 This is a repo for benchmarking functional features in Java.

## Tooling
[Java Microbenchmark Harness](https://github.com/openjdk/jmh) is the empire for all games. The gradle plugin [me.champeau.jmh](https://github.com/melix/jmh-gradle-plugin) makes running the benchmarking task as easy as `./gradlew jmh`. A lot of hyperparameters can be set up to tune the benchmarking details. Some examples can be found [here](https://www.baeldung.com/java-microbenchmark-harness), in addition to the official docs.

## Comparisons
Java is not a pure functional programming (FP) language, but there're some functional facilities since Java 8 to reduce the boilerplate code and boost readability. That is why the comparison are mostly between FP and OOD here.

## How-to
```bash
$ chmod +x ./gradlew
$ ./gradlew jmh
```

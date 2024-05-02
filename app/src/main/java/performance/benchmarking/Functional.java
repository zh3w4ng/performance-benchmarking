package performance.benchmarking;

import java.util.function.Function;

public class Functional {
    public static Function<Integer, Integer> multiply = (value) -> value * 2;
    public static Function<Integer, Integer> add = (value) -> value + 3;
    public static Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
    public static Function<Integer, Integer> multiplyFourTimes = multiply.andThen(multiply).andThen(multiply).andThen(multiply);
}

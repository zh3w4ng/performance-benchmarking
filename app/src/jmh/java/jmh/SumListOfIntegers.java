package jmh;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.BenchmarkMode;
import performance.benchmarking.Functional;
import performance.benchmarking.MapTable;

public class SumListOfIntegers {

    public long sumArray(int[] array) {
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static Integer doubleItStatic(Integer i) {
        return i * 2;
    }

    public Integer sumListV1(List<Integer> list) {
        Function<Integer, Integer> doubleIt = new Function<Integer, Integer>() {
            public Integer apply(Integer i) {
                return i * 2;
            }
        };
        return list.stream().map(doubleIt).reduce(0, Integer::sum);
    }

    public Integer sumListV2(List<Integer> list) {
        return list.stream().map(a -> a * 2) // Double each element
                .reduce(0, Integer::sum);
    }

    public Integer sumListV3(List<Integer> list) {
        return list.stream().map(SumListOfIntegers::doubleItStatic) // Double each element
                .reduce(0, Integer::sum);
    }

    public Integer sumListV4(List<Integer> list, MapTable mapTable) {
        return list.stream().map(i -> mapTable.multiply(i)) // Double each element
                .reduce(0, Integer::sum);
    }

    public Integer sumListV5(List<Integer> list, MapTable mapTable) {
        return list.stream().map(i -> mapTable.add(mapTable.multiply(i)))
                .reduce(0, Integer::sum);
    }

    public Integer sumListV6(List<Integer> list) {
        return list.stream().map(Functional.multiply).map(Functional.add)
                .reduce(0, Integer::sum);
    }

    public Integer sumListV7(List<Integer> list) {
        return list.stream().map(Functional.multiplyThenAdd)
                .reduce(0, Integer::sum);

    }

    public Integer sumListV8(List<Integer> list, MapTable mapTable) {
        return list.stream().map(i -> mapTable.multiply(mapTable.multiply(mapTable.multiply(mapTable.multiply(i)))))
                .reduce(0, Integer::sum);
    }

    public Integer sumListV9(List<Integer> list) {
        return list.stream().map(Functional.multiplyFourTimes)
                .reduce(0, Integer::sum);

    }

    public Integer sumListV10(List<Integer> list) {
        return list.stream().map(Functional.multiply)
                .reduce(0, Integer::sum);
    }

    /////////////////////////

    public void testSumListV1() {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV1(list);
    }

    public void testSumListV2() {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV2(list);
    }

    public void testSumListV3() {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV3(list);
    }

    public void testSumListV4(MapTable mapTable) {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV4(list, mapTable);
    }

    public void testSumListV5(MapTable mapTable) {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV5(list, mapTable);
    }

    public void testSumListV6() {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV6(list);
    }

    public void testSumListV7() {
        List<Integer> list = IntStream.range(0,
                100).limit(100).boxed().collect(Collectors.toList());
        sumListV7(list);
    }

    public void testSumListV8(MapTable mapTable) {
        List<Integer> list = IntStream.range(0, 100).limit(100).boxed().collect(Collectors.toList());
        sumListV8(list, mapTable);
    }

    public void testSumListV9() {
        List<Integer> list = IntStream.range(0,
                100).limit(100).boxed().collect(Collectors.toList());
        sumListV9(list);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testSumListV10() {
        List<Integer> list = IntStream.range(0,
                100).limit(100).boxed().collect(Collectors.toList());
        sumListV10(list);
    }
}

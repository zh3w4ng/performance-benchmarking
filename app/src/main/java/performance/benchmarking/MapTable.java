package performance.benchmarking;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


class Transformer {
    public Integer addThree(Integer input) {
        return input + 3;
    }

    public Integer multiplyTwo(Integer input) {
        return input * 2;
    }
}

@State(Scope.Benchmark)
public class MapTable {
    Transformer transformer;

    public Integer add(Integer i) {
        return transformer.addThree(i);
    }

    public Integer multiply(Integer i) {
        return transformer.multiplyTwo(i);
    }
    

    @Setup(Level.Invocation)
    public void setUp() {
        transformer = new Transformer();
    }
}

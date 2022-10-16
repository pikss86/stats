package stats.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class Avg<ItemType> implements StatFunc<ItemType> {
    private double avgValue;
    private long count;
    private final Consumer<Avg<ItemType>> printer;
    private final Function<ItemType, Long> mapper;

    public Avg(Function<ItemType, Long> mapper) {
        this(mapper, avg -> {});
    }

    public Avg(Function<ItemType, Long> mapper, Consumer<Avg<ItemType>> print) {
        avgValue = 0;
        count = 0;
        printer = print;
        this.mapper = mapper;
    }

    public void collect(ItemType item) {
        Long value = mapper.apply(item);
        if (value != null) {
            count++;
            avgValue += value;
        }
    }

    public double result() {
        return avgValue / count;
    }

    public void print() {
        printer.accept(this);
    }

}

package stats.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class Max<ItemType> implements StatFunc<ItemType> {

    private long maxValue;
    private final Consumer<Max<ItemType>> printer;
    private final Function<ItemType, Long> mapper;

    public Max(Function<ItemType, Long> mapper) {
        this(mapper, max -> {});
    }

    public Max(Function<ItemType, Long> mapper, Consumer<Max<ItemType>> print) {
        maxValue = Long.MIN_VALUE;
        printer = print;
        this.mapper = mapper;
    }

    public void collect(ItemType item) {
        Long value = mapper.apply(item);
        if (value != null)
            maxValue = Math.max(maxValue, value);
    }

    public long result() {
        return maxValue;
    }

    public void print() {
        printer.accept(this);
    }
}

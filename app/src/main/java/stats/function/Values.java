package stats.function;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class Values<ItemType> implements StatFunc<ItemType> {
    private final Set<String> valuesSet;
    private final Consumer<Values<ItemType>> printer;
    private final Function<ItemType, String> mapper;

    public Values(Function<ItemType, String> mapper) {
        this(mapper, values -> {});
    }

    public Values(Function<ItemType, String> mapper, Consumer<Values<ItemType>>  print) {
        valuesSet = new HashSet<>();
        printer = print;
        this.mapper = mapper;
    }

    public void collect(ItemType item) {
        String value = mapper.apply(item);
        if (value != null)
            valuesSet.add(value);
    }

    public Set<String> result() {
        return valuesSet;
    }

    public void print() {
        printer.accept(this);
    }
}

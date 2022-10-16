package stats.function;

public interface StatFunc<ItemType> {
    void print();
    void collect(ItemType item);
}

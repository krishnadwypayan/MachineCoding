package data;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Record<T> {
    private T val;

    public Record(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}

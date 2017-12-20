import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class myStream <T> {
    private final List<? extends T> list;

    public myStream(List<? extends T> list) {
        this.list = list;
    }

    public static<T> myStream<T> of (List<? extends T> list) {
        return new myStream<>(list);
    }

    public myStream<T> filter (Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) result.add(t);

        }
        return new myStream<>(result);
    }

    public myStream<T> transform (Function<T,T> function) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));

        }
        return new myStream<>(result);
    }

    public<K,V> Map<K,V> toMap(Function<T,K> key,Function<T,V> value) {
        Map<K,V> mappa = new HashMap<>();
        for (T t : list) {
            mappa.put(key.apply(t), value.apply(t));

        }
        return mappa;

    }
}

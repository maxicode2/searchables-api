package codes.maxi.searchables;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Util {
    public static <T, R> Function<T, R> memoize(final Function<T, R> function) {
        return new Function<T, R>(){
            private final Map<T, R> cache = new ConcurrentHashMap<>();
            
            @Override
            public R apply(T object) {
                return this.cache.computeIfAbsent(object, function);
            }
            
            public String toString() {
                return "memoize/1[function=" + function + ", size=" + this.cache.size() + "]";
            }
        };
    }
    
}

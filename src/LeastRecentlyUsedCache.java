import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeastRecentlyUsedCache<K,V> {

    // something is wrong in the book
    // to check late on


    private Map<K,V> map;

    public LeastRecentlyUsedCache(int cacheSize) {
        map = new LinkedHashMap<K,V>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > cacheSize;
            }
        };

    }
}

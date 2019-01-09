package h1.t4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangshibo
 */
public class LRUCache {

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

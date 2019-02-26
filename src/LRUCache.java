import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author He.H
 * @date 2018/12/26 21:06
 **/


public class LRUCache {
    Map<Integer,Integer> map ;
    Stack<Integer> stack;
    int size;

    public LRUCache(int capacity) {
        stack = new Stack<>();
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if(!stack.contains(key)){
            return -1;
        }
        boolean flag = stack.remove(Integer.valueOf(key));
        stack.push(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(stack.contains(key)){
            stack.remove(Integer.valueOf(key));
        }else{
            if(stack.size() == size){
                int count = stack.remove(0);
                map.remove(count);
            }
        }
        stack.push(key);
        map.put(key,value);
    }
}
class LRUCache1 {

    LinkedHashMap mCacheMap;
    int mCapacity;
    public LRUCache1(int capacity) {
        mCapacity = capacity;
        mCacheMap = new LinkedHashMap(capacity, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (mCapacity + 1 == mCacheMap.size()) {
                    return true;
                }
                return false;
            }
        };
    }

    public int get(int key) {
        if (mCacheMap.containsKey(key)) {
            return (int) mCacheMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        mCacheMap.put(key, value);
    }
}


package LeetCode;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> valToIndex;
    List<Integer> values;
    Random rand;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        values.add(val);
        valToIndex.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastVal = values.get(values.size() - 1);
        values.set(index, lastVal);
        valToIndex.put(lastVal, index);
        values.remove(values.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
package collections;

import java.util.*;

public class FrequencyOfElements {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequency(input);

        System.out.println(result);
    }
}

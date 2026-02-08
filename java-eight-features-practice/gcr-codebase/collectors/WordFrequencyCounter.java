package collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String paragraph = "Java is powerful and Java is popular and Java is fast";

        Map<String, Integer> wordFrequency = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum
                ));

        System.out.println("Word Frequency:\n");

        wordFrequency.forEach((word, count) ->
                System.out.println(word + " : " + count)
        );
    }
}

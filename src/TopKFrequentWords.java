import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new HashMap<>();
        PriorityQueue<String> pr = new PriorityQueue<String>(
                (w1, w2) -> wordMap.get(w1) == wordMap.get(w2) ?
                        w1.compareTo(w2) : wordMap.get(w2) -  wordMap.get(w1));

        for(int i=0; i < words.length; i++){
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }

        pr.addAll(wordMap.keySet());

        List<String> topKWords = new ArrayList<>();
        for(int i=0; i<k && !pr.isEmpty(); i++){
            topKWords.add(pr.poll());
        }
        return topKWords;
    }
}
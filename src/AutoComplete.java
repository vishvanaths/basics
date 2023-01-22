import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class AutoComplete {
    private static final List<String> DICTIONARY = new ArrayList<>();
    private static Map<Character, Trie> tries = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = "amazed,amused,amtrack,annoyed,ancesstor,astronaut, astronomy";
        Instant load = Instant.now();
        createTrie();
        Instant start = Instant.now();
        System.out.println(getAutocompleteList("con"));
        Instant end = Instant.now();
        Duration loadTime = Duration.between(load, start);
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time Taken to load:" + (loadTime));
        System.out.println("Time Taken:" + (timeElapsed));
    }

    private static void createTrie() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("d:/sparkdata/words_alpha.txt"))) {
            String word;
            while ((word = br.readLine()) != null) {
                Trie rootTrie = null;
                if(!tries.containsKey(word.charAt(0))){
                    rootTrie = new Trie(word.charAt(0));
                    tries.put(word.charAt(0), rootTrie);
                }
                rootTrie = tries.get(word.charAt(0));
                rootTrie.getWords().add(word);
                traverseTrie(rootTrie, word, 1);
            }
        }
    }

    private static void traverseTrie(Trie trie, String s, int position) {
        if(position < s.length()){
            char c = s.charAt(position);
            if(trie.getChildren().containsKey(c)){
                trie.getChildren().get(c).getWords().add(s);
            }else {
                Trie t1 = new Trie(s.charAt(0));
                t1.setC(c);
                t1.getWords().add(s);
                trie.getChildren().put(c, t1);
            }
            traverseTrie(trie.getChildren().get(c), s, position+1);
        }
    }

    public static Set<String> getAutocompleteList(String s){
        if(!tries.containsKey(s.charAt(0))) return new HashSet<>();

        Trie t = tries.get(s.charAt(0));
        if(s.length() > 1)
            for(char c: s.substring(1).toCharArray()){
                if(t.getChildren().containsKey(c)) {
                    t = t.getChildren().get(c);
                }else{
                    return new HashSet<>();
                }
            }

        return t.getWords();
    }
}

/**
 * SQL:
 * select * from where order_id (select order_id from(
 *  select order_id, max(order_datetime) from order_details order
 *  group by customer_id, order_datetime))
 **/
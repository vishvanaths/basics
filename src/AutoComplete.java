import java.util.*;

public class AutoComplete {
    private static final List<String> DICTIONARY = new ArrayList<>();
    private static Map<Character, Trie> tries = new HashMap<>();

    public static void main(String[] args) {
        String input = "amazed,amused,amtrack,annoyed,ancesstor,astronaut, astronomy";

        createTrie(input.split(","));
        System.out.println(getAutocompleteList("ancie"));
    }

    private static void createTrie(String[] split) {
        for(String s : split){
            Trie rootTrie = null;
            if(!tries.containsKey(s.charAt(0))){
                rootTrie = new Trie(s.charAt(0));
                tries.put(s.charAt(0), rootTrie);
            }
            rootTrie = tries.get(s.charAt(0));
            rootTrie.getWords().add(s);
            traverseTrie(rootTrie, s, 1);
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
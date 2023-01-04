import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    private Character c;
    private Set<String> words = new HashSet<>();
    private Map<Character, Trie> children = new HashMap<>();

    public Trie(Character c) {
        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public Set<String> getWords() {
        return words;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }

    public Map<Character, Trie> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Trie> children) {
        this.children = children;
    }
}

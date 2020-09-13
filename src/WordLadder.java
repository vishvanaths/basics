import java.util.*;
import java.util.LinkedList;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot","dog"};

        System.out.println(ladderLength(beginWord,endWord, new ArrayList<>(Arrays.asList(wordList))));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList1) {
        Set<String> wordList = new HashSet<>(wordList1);
        if(!wordList.contains(endWord)){
            return 0;
        }
        int level = 1;
        Queue<String> words = new LinkedList<>();
        words.offer(beginWord);

        while(!words.isEmpty()){
            int size = words.size();
            boolean foundNext = false;
            for(int i=0;i<size;i++){
                String word = words.poll();
                char[] c = word.toCharArray();
                for(int j=0; j<word.length(); j++){
                    char original = c[j];
                    for(char k='a'; k <= 'z'; k++){
                        if(original != k) {
                            c[j] = k;
                            String newWord = String.valueOf(c);
                            if(wordList.contains(newWord)){
                                if(newWord.equals(endWord)) return level + 1;
                                words.offer(newWord);
                                wordList.remove(newWord);
                                foundNext = true;
                            }
                        }

                    }
                    c[j] = original;
                }
            }
            if(!foundNext) return 0;
            level++;
        }
        return level;
    }
}

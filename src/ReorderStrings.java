import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorderStrings {
    public static void main(String[] args) {
        String S = "aab";

//        System.out.println(reorderedString(S));
        System.out.println(reorderedString2(S));
    }
    public static String reorderedString(String S){
        int N = S.length();
        int[] chars = new int[26];
        for(char c : S.toCharArray()) chars[c - 'a'] += 100;
        for(int i=0; i < 26; i++) chars[i] += i;

        Arrays.sort(chars);

        char[] ans = new char[N];
        int t=1;

        for(int counts : chars){
            int ct = counts/100;
            char c = (char)(counts%100 + 'a');

            if(ct > ((N+1)/2)) return "";
            else{
                for(int i=0;i<ct;i++){
                    if(t >= N) t=0;
                    ans[t] = c;
                    t = t+2;
                }
            }

        }

        return String.valueOf(ans);
    }

    public static String reorderedString2(String S) {
        Map<Character, Integer> chars = new HashMap<>();
        for(char c : S.toCharArray()) chars.put(c, chars.getOrDefault(c,0) + 1);

//        PriorityQueue<CharInfo> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.count == o2.count ? o1.character - o2.character : o1.count - o2.count);
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> chars.get(o2) - chars.get(o1));
//        for(Map.Entry<Character, Integer> keyVal : chars.entrySet()){
//
//        }

        priorityQueue.addAll(chars.keySet());

        StringBuilder ans = new StringBuilder();

        while(priorityQueue.size() >= 2){
            Character firstCharacter = priorityQueue.poll();
            Character secondCharacter = priorityQueue.poll();

            ans.append(firstCharacter);
            ans.append(secondCharacter);

            if(chars.get(firstCharacter) - 1 > 0){
                chars.put(firstCharacter, chars.get(firstCharacter) - 1);
                priorityQueue.add(firstCharacter);
            }

            if(chars.get(secondCharacter) - 1 > 0){
                chars.put(secondCharacter, chars.get(secondCharacter) - 1);
                priorityQueue.add(secondCharacter);
            }
        }

        if(!priorityQueue.isEmpty()){
            Character lastCharacter = priorityQueue.poll();
            if(chars.get(lastCharacter) - 1 > 0){
                return "";
            }
            ans.append(lastCharacter);
        }

        return ans.toString();
    }
}

class CharInfo{
    public int count;
    public char character;

    public CharInfo(char character, int count){
        this.character = character;
        this.count = count;
    }
}


/***
 *767. Reorganize String
 * Medium
 *
 * 1977
 *
 * 88
 *
 * Add to List
 *
 * Share
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 *
 **/
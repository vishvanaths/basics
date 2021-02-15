import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_L49 {
    public static void main(String[] args) {
        String[] strs =  new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] arr = new int[26];
            for(char c: s.toCharArray()){
                arr[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append("#"+i);
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(),new ArrayList<>());
            }
            map.get(sb.toString()).add(s);
        }

        return  new ArrayList(map.values());
    }
}

/**
 * 49. Group Anagrams
 * Medium
 *
 * 4893
 *
 * 221
 *
 * Add to List
 *
 * Share
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */

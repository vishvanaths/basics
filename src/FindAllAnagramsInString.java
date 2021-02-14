import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s= "abab", p= "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()){
            return result;
        }

        int[] pChar = new int[26];
        for(char c:p.toCharArray()){
            pChar[c - 'a']++;
        }
        int sEnd =0;
        int[] sChar = new int[26];
        int sStart=0;
        for(;sEnd<s.length();sEnd++){
            if(sEnd-sStart < p.length()){
                sChar[s.charAt(sEnd) - 'a']++;
            }else{
                if(Arrays.equals(sChar,pChar)){
                    result.add(sStart);
                }
                sChar[s.charAt(sStart)-'a']--;
                sChar[s.charAt(sEnd) - 'a']++;
                sStart++;
            }
        }

        if(Arrays.equals(sChar,pChar)){
            result.add(sStart);
        }

        return result;
    }
}
/**
 * 438. Find All Anagrams in a String
 * Medium
 *
 * 3885
 *
 * 194
 *
 * Add to List
 *
 * Share
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacters_Oracle {
    public static void main(String[] args) {
        System.out.println(longestKUniqueCharacterSubstring("aabbcc", 3));
    }

    private static int longestKUniqueCharacterSubstring(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int result = 1;
        Map<Character, Integer> charPosMap = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right < s.length()){
            charPosMap.put(s.charAt(right), right);
            right++;

            if(charPosMap.size() == k+1){
                left = Collections.min(charPosMap.values());
                charPosMap.remove(s.charAt(left));
                left = left +1;
            }
            result = Math.max(result, right - left);
        }

        return result;
    }
}


/**
 * Find the longest substring with k unique characters in a given string
 * Difficulty Level : Hard
 * Last Updated : 22 Nov, 2022
 * Read
 * Discuss(120+)
 * Courses
 * Practice
 * Video
 *
 * Given a string you need to print longest possible substring that has exactly M unique characters. If there is more than one substring of longest possible length, then print any one of them.
 *
 * Examples:
 *
 * Input: Str = “aabbcc”, k = 1
 * Output: 2
 * Explanation: Max substring can be any one from {“aa” , “bb” , “cc”}.
 *
 * Input: Str = “aabbcc”, k = 2
 * Output: 4
 * Explanation: Max substring can be any one from {“aabb” , “bbcc”}.
 *
 *
 * Input: Str = “aabbcc”, k = 3
 * Output: 6
 * Explanation:
 * There are substrings with exactly 3 unique characters
 * {“aabbcc” , “abbcc” , “aabbc” , “abbc” }
 * Max is “aabbcc” with length 6.
 *
 * Input: Str = “aaabbb”, k = 3
 * Output: Not enough unique characters
 * Explanation: There are only two unique characters, thus show error message.
 **/
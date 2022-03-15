import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_L3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        if(s.length() == 1) return 1;

        int length = 0;
        int start = 0;
        int end = 0;

        Set<Character> chars = new HashSet();
        while(end < s.length()){
            if(!chars.contains(s.charAt(end))){
                chars.add(s.charAt(end));
                length = Math.max(chars.size(), length);
            }else{
                chars.add(s.charAt(end));
                chars.remove(s.charAt(start));
                start++;
            }
            end++;
        }
        return length;
    }
}

/**
 *
 */
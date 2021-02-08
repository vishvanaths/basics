public class ValidAnagram_L242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if((s == null && t != null) || (s != null && t == null)){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        int[] chars = new int[26];

        for(int i=0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for(int i:chars){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
/**
 * 242. Valid Anagram
 * Easy
 *
 * 2187
 *
 * 157
 *
 * Add to List
 *
 * Share
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

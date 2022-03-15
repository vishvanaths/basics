public class MaxLengthOfConcatenatedString_L1239 {
    public static void main(String[] args) {
        String[] array = new String[]{"un","iq","ue"};
        System.out.println(maxLength(array));
    }

    public static int maxLength(String[] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return array[0].length();
        }
        int[] length = new int[1];
        findMaxLength(array, 0, "", length);
        return length[0];
    }

    private static void findMaxLength(String[] array, int i, String s, int[] length) {
        if(i >= array.length){
            return;
        }
        
        String newStr = s + array[i];
        boolean isUnique = isUniqueCharacterString(newStr);
        if(!isUnique){
            return;
        }
        if(isUnique && length[0] < newStr.length()){
            length[0] = newStr.length();
        }
        findMaxLength(array, i+1, newStr, length);
        findMaxLength(array, i+1, s, length);
    }

    private static boolean isUniqueCharacterString(String newStr) {
        int[] charArray = new int[26];
        for(char c : newStr.toCharArray()){
            charArray[c - 'a']++;
            if(charArray[c - 'a'] > 1){
                return false;
            }
        }
        return true;
    }

}

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * Medium
 *
 * 1674
 *
 * 151
 *
 * Add to List
 *
 * Share
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 */
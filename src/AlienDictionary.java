public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"apap", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    /**
     * ["apap","app"]
     * "abcdefghijklmnopqrstuvwxyz"
     *
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int[] characterPosition = new int[26];

        for (int i = 0; i < order.length(); i++) {
            characterPosition[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            int length = Math.min(currentWord.length(), nextWord.length());
            for (int j = 0; j < length; j++) {
                final int fChar = characterPosition[currentWord.charAt(j) - 'a'];
                final int sChar = characterPosition[nextWord.charAt(j) - 'a'];
                if (fChar != sChar) {
                    if (fChar > sChar) {
                        return false;
                    } else {
                        length = -1;
                    }
                }
            }
            if (length != -1 && currentWord.length() > nextWord.length()) {
                return false;
            }
        }
        return true;
    }
}


/***
 *953. Verifying an Alien Dictionary
 * Easy
 *
 * 1066
 *
 * 434
 *
 * Add to List
 *
 * Share
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
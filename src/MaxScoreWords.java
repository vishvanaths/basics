public class MaxScoreWords {
    public static void main(String[] args) {
        String[] words = {"ac","abd","db","ba","dddd","bca"};
        String[] letters = {"a","a","a","b","b","b","c","c","d","d","d","d"};
        int[] score = {6,4,4,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // ["ac","abd","db","ba","dddd","bca"]
        // ["a","a","a","b","b","b","c","c","d","d","d","d"]
        // [6,4,4,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        System.out.println(maxScoreWords(words, letters, score));
    }
    public static int maxScoreWords(String[] words, String[] letters, int[] score) {
        int[] count = new int[26];
        for(String s : letters){
            char c = s.charAt(0);
            count[c - 'a']++;
        }

        int res = dfs(words, count, score, 0);//maximum scroe we can get start from words[0];
        return res;
    }
    private static int dfs(String[] words, int[] count, int[] score, int index) {    
        if(index >= words.length){
            return 0;
        }
        int withWord = 0;
        String word = words[index];
        boolean viableWord = true;
        for(char c : word.toCharArray()){
            count[c - 'a']--;
            if(count[c - 'a'] < 0){
                viableWord = false;
            }else{
                withWord += score[c - 'a'];
            }
        }

        if(viableWord){
            withWord += dfs(words, count, score, index + 1);
        }else{
            withWord = 0;
        }

        for(char c : word.toCharArray()){
            count[c - 'a']++;
        }
        int withoutWord = dfs(words, count, score, index+1);

        return Math.max(withWord, withoutWord);
    }
}

/**
 * Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.

 

Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.

Example 2:

Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
Output: 27
Explanation:
Score  a=4, b=4, c=4, x=5, z=10
Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
Word "xxxz" only get a score of 25.

Example 3:

Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
Output: 0
Explanation:
Letter "e" can only be used once.
 

Constraints:

1 <= words.length <= 14
1 <= words[i].length <= 15
1 <= letters.length <= 100
letters[i].length == 1
score.length == 26
0 <= score[i] <= 10
words[i], letters[i] contains only lower case English letters.
 * 
 */
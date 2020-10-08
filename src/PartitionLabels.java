import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "caedbdedda";

        partitionLabels(s);
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int[] chars = new int[26];

        for(int i=0; i < s.length(); i++){
            chars[s.charAt(i) - 'a'] = i;
        }

        int j=0;

        while(j < s.length()){
            int end = chars[s.charAt(j) - 'a'];
            int i = j;
            while (i < end){
                end = Math.max(end, chars[s.charAt(i) - 'a']);
                i++;
            }
            partitions.add(end - j + 1);
            j = i+1;
        }

        return partitions;
    }
}

/***
 * 763. Partition Labels
 * Medium
 *
 * 3348
 *
 * 137
 *
 * Add to List
 *
 * Share
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */

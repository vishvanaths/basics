import java.util.Map;
import java.util.TreeMap;

public class HandofStraights_L846 {
    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8}; int W = 3;
        System.out.println(isNStraightHand(hand, W));
    }
    public static boolean isNStraightHand(int[] hand, int W) {
        if(hand == null || hand.length == 0 || hand.length % W != 0){
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int card : hand){
            treeMap.put(card, treeMap.getOrDefault(card, 0) + 1);
        }

        while (treeMap.size() > 0){
            int initial = treeMap.firstKey();
            for(int i=0; i < W; i++){
                if(treeMap.containsKey(initial + i)){
                    if(treeMap.get(initial + i) == 1){
                        treeMap.remove(initial+i);
                    }else{
                        treeMap.put(initial + i, treeMap.get(initial + i ) - 1);
                    }
                }else{
                    return false;
                }
            }
        }

        return treeMap.isEmpty();
    }
}


/**
 *846. Hand of Straights
 * Medium
 *
 * 897
 *
 * 93
 *
 * Add to List
 *
 * Share
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 * Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 *
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 *
 *
 * Constraints:
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class HammingDistance_L461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
    public static int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        int mask = 1;
        int distance = 0;
        while(xorResult != 0){
            distance+= (xorResult & mask);
            xorResult = xorResult>>1;
        }
        return distance;
    }
}

/**
 * 461. Hamming Distance
 * Easy
 *
 * 2097
 *
 * 174
 *
 * Add to List
 *
 * Share
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
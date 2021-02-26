public class ArmstrongNumber_L1134 {
    public boolean isArmstrong(int N) {
        int digits = String.valueOf(N).length();
        int originalNumber = N;
        int sum = 0;
        while(N!=0){
            sum += Math.pow(N%10 , digits);
            N = N/10;
            if(sum > originalNumber){
                return false;
            }
        }
        return sum == originalNumber;
    }
}


/**
 * 1134. Armstrong Number
 * Easy
 *
 * 86
 *
 * 12
 *
 * Add to List
 *
 * Share
 * The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.
 *
 * Given a positive integer N, return true if and only if it is an Armstrong number.
 *
 *
 *
 * Example 1:
 *
 * Input: 153
 * Output: true
 * Explanation:
 * 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 * Example 2:
 *
 * Input: 123
 * Output: false
 * Explanation:
 * 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
 *
 *
 * Note:
 *
 * 1 <= N <= 10^8
 */
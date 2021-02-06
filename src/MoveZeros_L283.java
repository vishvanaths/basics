import java.util.Arrays;

public class MoveZeros_L283 {
    public static void main(String[] args) {
        int[] numbers = new int[]{0,1,0,3,12};
        Arrays.stream(moveZeroes(numbers)).forEach(value -> System.out.print(value + ","));
    }
    public static int[] moveZeroes(int[] numbers) {
        int pos =0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0){
                numbers[pos++] = numbers[i];
            }
        }

        while(pos < numbers.length){
            numbers[pos++]=0;
        }
        return numbers;
    }
}

/**
 * 283. Move Zeroes
 * Easy
 *
 * 4978
 *
 * 155
 *
 * Add to List
 *
 * Share
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
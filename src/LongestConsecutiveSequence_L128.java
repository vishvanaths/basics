import java.util.HashSet;

public class LongestConsecutiveSequence_L128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums ==  null || nums.length == 0){
            return 0;
        }

        HashSet<Integer> numbers = new HashSet<>();
        for(int number : nums){
            numbers.add(number);
        }


        int maxSequence = 1;

        for(int i=0; i < nums.length; i++){
            int currentMaxSeq = 1;
            if(!numbers.contains(nums[i] - 1)){
                int currentNumber = nums[i];
                while(numbers.contains(currentNumber + 1)){
                    currentMaxSeq++;
                    currentNumber++;
                }
            }
            maxSequence = Math.max(maxSequence, currentMaxSeq);
        }
        return maxSequence;
    }
}

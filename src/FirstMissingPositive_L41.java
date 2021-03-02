public class FirstMissingPositive_L41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        int MAX_NUM = nums.length;

        boolean onePresent = false;

        for(int i=0;i<MAX_NUM; i++){
            if(nums[i] == 1){
                onePresent = true;
                break;
            }
        }

        if(!onePresent) return 1;

        if (MAX_NUM == 1)
            return 2;

        for(int i=0;i<MAX_NUM; i++){
            if(nums[i] <= 0 || nums[i] >MAX_NUM ){
                nums[i] = 1;
            }
        }

        for(int i=0;i<MAX_NUM; i++){
            int a = Math.abs(nums[i]);

            if (a == MAX_NUM)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        for(int i=1;i<MAX_NUM; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        if(nums[0] > 0){
            return MAX_NUM;
        }
        return MAX_NUM+1;
    }
}

/**
 *
 */

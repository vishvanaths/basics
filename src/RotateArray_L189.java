public class RotateArray_L189 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int k=2;
        rotate(nums, k);
    }

    private static void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }
        int l = nums.length;
        k = k % l;

        int count = 0;
        for(int iterator = 0; count < l; iterator++){
            int current = iterator;
            int prev = nums[current];
            do{
                int next = (current + k)%l;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                count++;

            }while(iterator != current);
        }

        return;
    }
}

public class ProductArrayExceptItself {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        productExceptSelf(arr);
    }

    public static int[] productExceptSelf(int[] nums) {
        final int length = nums.length;
        int[] results = new int[length];
        results[0] = 1;

        for(int i = 1; i < length; i++){
            results[i] = nums[i-1] * results[i-1];
        }
        int[] right = new int[length];
        right[length - 1] = 1;
        for(int i = length - 2 ; i >= 0; i--){
            right[i] = nums[i + 1] * right[i+1];
        }
        for(int i = 0; i < length; i++){
            results[i] = results[i] * right[i];
        }
        return results;
    }
}

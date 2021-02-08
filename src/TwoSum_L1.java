import java.util.HashMap;
import java.util.Map;

public class TwoSum_L1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15}; int target = 9;
        System.out.println(twoSum(nums,target));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[]{-1, -1};
        if(nums == null || nums.length < 2){
            return result;
        }
        Map<Integer, Integer> compliments = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(compliments.containsKey(compliment)){
                result[0]=compliments.get(compliment);
                result[1]=i;
                break;
            }else{
                compliments.put(compliment, i);
            }
        }
        return result;
    }
}

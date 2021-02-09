import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement_L215 {
    public static void main(String[] args) {
        int nums[] = new int[] {3,2,3,1,2,4,5,5,6};
        int k=4;

        System.out.println(kthLargestElement(nums, k));
    }

    public static int kthLargestElement(int[] nums, int k) {
        if(nums != null && nums.length < k){
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int num : nums){
            maxHeap.add(num);
        }

        for(int i=0; i<k-1; i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public int findKthLargest_trimHeap(int[] nums, int k) {
        if(nums != null && nums.length < k){
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }


        return minHeap.poll();
    }

    public int findKthLargest_sortedArray(int[] nums, int k) {
        if(nums != null && nums.length < k){
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

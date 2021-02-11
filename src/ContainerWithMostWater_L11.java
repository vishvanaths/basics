public class ContainerWithMostWater_L11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] heights) {
        if(heights==null || heights.length<=1){
            return -1;
        }

        int start = 0;
        int end = heights.length -1;
        int max = 0;
        while (start < end){
            int minBar = Math.min(heights[start], heights[end]);
            max = Math.max(max, (end - start) * minBar);
            if(heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }

        return max;
    }
}

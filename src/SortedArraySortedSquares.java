public class SortedArraySortedSquares {
    public static void main(String[] args) {
        int[] arr = {-5,-3, -2, 0, 1, 4, 9};

        System.out.println(printArray(sortedSquares(arr)));
    }
    //Faster
    private static  int[] sortedSquares(int[] nums) {
        int[] results = new int[nums.length];

        int start = 0;
        int end = nums.length -1;
        int ptr = nums.length -1;
        while(ptr >=0 ){
            if(Math.abs(nums[start]) < Math.abs(nums[end])){
                results[ptr--] = nums[end] * nums[end];
                end--;
            }else{
                results[ptr--] = nums[start] * nums[start];
                start++;
            }
        }
        return results;
    }

    private static int[] sortedSquares1(int[] arr) {
        if(arr == null || arr.length == 0){
            return arr;
        }
        int[] sortedArray = new int[arr.length];
        if(arr[0] >= 0){
            for(int i=0;i<arr.length;i++){
                sortedArray[i] = arr[i] * arr[i];
            }
        }else if(arr[arr.length - 1] < 0){
            for(int i=arr.length -1; i>=0;i--){
                sortedArray[i] = arr[i] * arr[i];
            }
        }else{
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= 0){
                    int l = 0;
                    int j = i;
                    int k = i-1;
                    while(j<arr.length && k >= 0){
                        if(arr[j] < Math.abs(arr[k])){
                            sortedArray[l] = arr[j] * arr[j];
                            l++;
                            j++;
                        }else{
                            sortedArray[l] = arr[k] * arr[k];
                            l++;
                            k--;
                        }
                    }
                    while(j<arr.length){
                        sortedArray[l] = arr[j] * arr[j];
                        l++;
                        j++;
                    }
                    while(k >= 0){
                        sortedArray[l] = arr[k] * arr[k];
                        l++;
                        k--;
                    }
                    break;
                }
            }
        }
        return sortedArray;
    }

    private static String printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean addComma = false;
        for(int i : a){
            sb.append((addComma ? "," : "") + i);
            addComma = true;
        }
        sb.append("]");

        return sb.toString();
    }
}

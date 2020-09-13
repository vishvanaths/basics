public class SortedArrayFindFindFirstAndLastElement {
    public static void main(String[] args) {
        int[] arr = {-5,-3,0,1,2,3,4,5,5,5,5,5,8,9};
        findFistAndLastPosition(arr, 5);
    }

    private static void findFistAndLastPosition(int[] arr, int i) {
        int first = findItem(arr, i, true);
        int last = findItem(arr, i, false);
        System.out.println(first + "," + last);
    }

    private static int findItem(int[] arr, int x, boolean lower) {
        int high = arr.length -1, low = 0;
        int mid = -1;
        while(low <= high ){
            mid = (low+high)/2;
            if(lower && (mid ==0 || (x > arr[mid - 1] && x == arr[mid]))){
                return mid;
            }
            if(!lower && (mid ==arr.length -1 || (x < arr[mid +1] && x == arr[mid]))){
                return mid;
            }

            if(lower){
                if(arr[mid] >= x){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(arr[mid] <= x){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }

        }
        return mid;
    }
}

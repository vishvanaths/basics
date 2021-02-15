import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements_L658 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,10,10,10}; int k=1, x=9;
        System.out.println(findClosestElements(arr, k, x));
    }

    // This is better solution any way
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;
        while(start < end)
        {
            int mid = start + (end-start)/2;
            if(x-arr[mid] > arr[mid+k] -x)
            {
                start = mid+1;
            }
            else
            {
                end=mid;
            }
        }
        List<Integer> list = new ArrayList<>(k);
        for (int i = start; i < start+k; i++)
        {
            list.add(arr[i]);
        }
        return list;
    }

    //Slower
    public static List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        List<Integer> closestElelemnts = new ArrayList<>();
        if(arr == null || arr.length == 0 || arr.length < k){
            return closestElelemnts;
        }

        if(x < arr[0]){
            for(int i=0;i<k;i++)
                closestElelemnts.add(arr[i]);
        }else if(x > arr[arr.length - 1]){
            for(int i=arr.length-k-1; i< arr.length;i++)
                closestElelemnts.add(arr[i]);
        }else{
            int position = -1;

            for(int i=0; i<arr.length; i++){
                if(arr[i] == x){
                    position = i;
                    break;
                }else if(arr[i] > x){
                    position = i-1;
                    break;
                }
            }

            int i=position;
            int j=position+1;

            while(k != 0){
                if(i >= 0 && j < arr.length){
                    if(Math.abs(arr[i]-x) <= arr[j]-x){
                        closestElelemnts.add(arr[i]);
                        i--;
                    }else{
                        closestElelemnts.add(arr[j]);
                        j++;
                    }
                }else if(i < 0 && j < arr.length){
                    closestElelemnts.add(arr[j]);
                    j++;
                }else{
                    closestElelemnts.add(arr[i]);
                    i--;
                }

                k--;
            }

        }
        Collections.sort(closestElelemnts);
        return closestElelemnts;
    }

}

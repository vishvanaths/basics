public class EqualizeArray {

    static int equalizeArray(int[] arr) {
        int[] frequencyArr = new int[101];
        int max = 0;

        for(int a : arr){
            frequencyArr[a]++;
            if(max < frequencyArr[a]){
                max = frequencyArr[a];
            }
        }

        return arr.length - max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,5,5}; // how many element delete is required to have only equalized array [array with elements of same value]
        System.out.println( equalizeArray(arr));
    }
}
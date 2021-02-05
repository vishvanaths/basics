import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = {4,5,2,3,6,9,12,0,1,2};
        System.out.println("Select algorithm \n 1. Selection sort \n 2. Bubble Sort");
        System.out.println(" 3. Insertion sort \n 4. Merge Sort \n 5. Quick Sort");
        System.out.print(" Selection ====>");

        int i = Integer.parseInt(sc.nextLine().trim());
        System.out.println(" Input:" + arrayToString(a));

        switch(i){
            case 1 :
            selectionSort(a);
            break;
            
            case 2 :
            bubbleSort(a);
            break;        
            
            case 3 :
            insertionSort(a);
            break;      
            
            case 4 :
            a = mergeSort(a);
            break;     

            case 5 :
            quickSort(a, 0, a.length - 1);
            break;                        
        }

        System.out.println(" Output:" + arrayToString(a));
    }

    private static void quickSort(int[] a, int start, int end) {
        if(start >= end){
            return;
        }
        int pIndex = partition(a, start, end);       
        quickSort(a, start, pIndex - 1);
        quickSort(a, pIndex + 1, end);
    }

    // Do later
    // private static int randomizePartition(int[] a, int start, int end) {
    //     int pivot = (int) (Math.random() * (end - start + 1) + start);
    //     a[end] = a[end] + a[pivot];
    //     a[pivot] = a[end] - a[pivot];
    //     a[end] = a[end] - a[pivot];
    //     return partition(a, start, end);
    // }

    
    private static int partition(int[] a, int start, int end) {
        int pivot = end;
        int pIndex = start;

        for(int i=start;i<end; i++){
            if(a[i] <= a[pivot]){
//                a[pIndex] = a[pIndex] + a[i];
//                a[i] = a[pIndex] - a[i];
//                a[pIndex] = a[pIndex] - a[i];
                swap(a, pIndex, i);
                pIndex++;
            }
        }
//        a[pIndex] = a[pIndex] + a[pivot];
//        a[pivot] = a[pIndex] - a[pivot];
//        a[pIndex] = a[pIndex] - a[pivot];
        swap(a, pIndex, pivot);
        return pIndex;
    }

    private static void swap(int[] a, int i, int j){
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    private static int[] mergeSort(int[] a) {
        if(a.length == 1){
            return a;
        }
        int breakIndex = (int) a.length/2;
        
        int[] leftArray = mergeSort(Arrays.copyOfRange(a, 0, breakIndex));
        int[] rightArray = mergeSort(Arrays.copyOfRange(a, breakIndex + 1, a.length));
        return mergeArrays(leftArray, rightArray);
    }

    private static int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int[] tempArray = new int[leftArray.length + rightArray.length];
        int i=0;
        int j=0;
        int k=0;
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] < rightArray[j]){
                tempArray[k] = leftArray[i];
                i++;
                k++;
            }else{
                tempArray[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while(i < leftArray.length ){
            tempArray[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightArray.length){
            tempArray[k] = rightArray[j];
            j++;
            k++;
        }
        return tempArray;
    }

    private static void insertionSort(int[] a) {
        for(int i=1;i<a.length;i++){
            int val = a[i];
            int hole = i;
            while(hole > 0 && a[hole - 1] > val){
               a[hole] = a[hole - 1];
               hole--;
            }
            a[hole] = val;

        }
    }

    private static void selectionSort(int[] a) {
        for(int i=0;i<a.length - 1;i++){
            int min = i;
            for(int j = i + 1;j<a.length;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }

            if(min != i) {
                a[i] = a[i] + a[min];
                a[min] = a[i] - a[min];
                a[i] = a[i] - a[min];
            }

            System.out.println(arrayToString(a));
        }
    }
    
    private static void bubbleSort(int[] a) {
        for(int i=0;i<a.length - 1;i++){
            boolean swapped = false;
            for(int j = 0;j<a.length - 1 - i;j++){
                if(a[j] > a[j+1]) {
                    a[j+1] = a[j] + a[j+1];
                    a[j] = a[j+1] - a[j];
                    a[j+1] = a[j+1] - a[j];
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
            System.out.println(arrayToString(a));
        }
	}

    public static String arrayToString(int[] a) {
        StringBuilder sb =  new StringBuilder();
        sb.append("Length: [" + a.length +"], [ ");
        for(int i : a){
            sb.append(i + ", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
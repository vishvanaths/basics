import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PythagoreanTripletInArray {
    public static void main(String[] args) {
        System.out.println("Pythagorean Triplet [3, 1, 4, 6, 5] : " + pythagoreanTripletInArray(new int[]{3, 1, 4, 6, 5}));
    }

    private static Set<Set<Integer>> pythagoreanTripletInArray(int[] numbers) {
        Set<Set<Integer>> triplets = new HashSet<>();
        if(numbers == null || numbers.length <= 2) return triplets;

        int size = numbers.length;
        Arrays.sort(numbers);

        for(int i=0; i<size; i++){
            numbers[i] = numbers[i] * numbers[i];
        }
        for(int i=size-1; i>=2; i--){
            int number = numbers[i];
            int left = 0;
            int right = i-1;

            while(left < right){
                int sum = numbers[left] + numbers[right];
                if(sum == number){
                    Set<Integer> triplet = new HashSet<>();
                    triplet.add((int)Math.sqrt((double) numbers[left]));
                    triplet.add((int)Math.sqrt((double) numbers[right]));
                    triplet.add((int)Math.sqrt((double) number));
                    triplets.add(triplet);
                    break;
                } else if(sum < number){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return triplets;
    }
}

import java.util.ArrayList;
import java.util.List;

public class MaximumCandies {
    public static void main(String[] args) {
        int[] a = {2,3,5,1,3};
        int extra = 3;
        System.out.println(kidsWithCandies(a, extra));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxCandies = -1;
        for(int i=0; i<candies.length; i++){
            if(maxCandies < candies[i])
                maxCandies = candies[i];
        }

        for(int i=0; i<candies.length; i++){
            if(maxCandies <= candies[i] + extraCandies)
            list.add(true);
            else
            list.add(false);
        }

        return list;
    }
}
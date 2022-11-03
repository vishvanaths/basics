import java.util.Arrays;

public class TwoCityScheduling_L1029 {
    public static void main(String[] args) {
        System.out.println(twoCityScheduleCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }

    public static int twoCityScheduleCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[0]-o1[1] - (o2[0]-o2[1]));

        int low = 0;
        int high = costs.length -1;
        int cost = 0;
        while(low < high){
            //System.out.println("[" + costs[low][0] + ":" + costs[low][1] + "]");
            //System.out.println("[" + costs[high][0] + ":" + costs[high][1] + "]");
            cost = cost + costs[low][0] + costs[high][1];
            low++;
            high--;
        }

        return cost;
    }
}

/**
 * 1029. Two City Scheduling
 * Medium
 *
 * 4010
 *
 * 298
 *
 * Add to List
 *
 * Share
 * A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
 *
 * Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * Example 2:
 *
 * Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * Output: 1859
 * Example 3:
 *
 * Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * Output: 3086
 *
 *
 * Constraints:
 *
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length is even.
 * 1 <= aCosti, bCosti <= 1000
 * Accepted
 * 198,005
 * Submissions
 * 306,394
 */
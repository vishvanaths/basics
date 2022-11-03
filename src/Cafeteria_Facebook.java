import java.util.Arrays;

public class Cafeteria_Facebook {

    public static void main(String[] args) {
        Cafeteria_Facebook cf = new Cafeteria_Facebook();
        System.out.println(cf.getMaxAdditionalDinersCount(10L, 1L, 2, new long[]{2,6}));
        System.out.println(cf.getMaxAdditionalDinersCount(15L, 2L, 3, new long[]{11, 6, 14}));
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long result = 0;
        long start = 1, end;

        for(int i=0; i<M; ++i) {
            end = S[i] - K - 1;
            result += getCount(start, end, K);
            start = S[i] + K + 1;
        }
        result += getCount(start, N, K);
        return result;
    }

    private long getCount(long start, long end, long K) {
        return start > end ? 0 : (end - start)/(K + 1) + 1;
    }
}

/**
 * Cafeteria
 * Level 1
 * Time limit: 5s
 * Solved
 * A cafeteria table consists of a row of NN seats, numbered from 11 to NN from left to right.
 * Social distancing guidelines require that every diner be seated such that KK seats to their left and KK seats to their
 * right (or all the remaining seats to that side if there are fewer than KK) remain empty.
 * There are currently MM diners seated at the table, the iith of whom is in seat S_iS
 * i
 * ​
 *  . No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 * Determine the maximum number of additional diners who can potentially sit at the table without social distancing
 * guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the
 * additional diners will cooperate to maximize how many of them can sit down.
 * Please take care to write a solution which runs within the time limit.
 * Constraints
 * 1 \le N \le 10^{15}1≤N≤10
 * 15
 *
 * 1 \le K \le N1≤K≤N
 * 1 \le M \le 500{,}0001≤M≤500,000
 * M \le NM≤N
 * 1 \le S_i \le N1≤S
 * i
 * ​
 *  ≤N
 * Sample test case #1
 * N = 10
 * K = 1
 * M = 2
 * S = [2, 6]
 * Expected Return Value = 3
 * Sample test case #2
 * N = 15
 * K = 2
 * M = 3
 * S = [11, 6, 14]
 * Expected Return Value = 1
 * Sample Explanation
 * In the first case, the cafeteria table has N = 10N=10 seats, with two diners currently at seats 22 and 66 respectively.
 * The table initially looks as follows, with brackets covering the K = 1K=1 seat to the left and right of each existing diner that may not be taken.
 *   1 2 3 4 5 6 7 8 9 10
 *   [   ]   [   ]
 * Three additional diners may sit at seats 44, 88, and 1010 without violating the social distancing guidelines.
 * In the second case, only 11 additional diner is able to join the table, by sitting in any of the first 33 seats.
 */
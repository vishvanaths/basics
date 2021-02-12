public class TownJudge_L997 {
    public static void main(String[] args) {
        int N = 4;
        int[][] trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(N, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        if (N == 0 || trust == null) {
            return -1;
        }
        if (trust.length < N - 1) {
            return -1;
        }
        int[] trustedPerson = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            trustedPerson[trust[i][0]]--;
            trustedPerson[trust[i][1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if(trustedPerson[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}

/**
 * 997. Find the Town Judge
 * Easy
 * <p>
 * 1374
 * <p>
 * 110
 * <p>
 * Add to List
 * <p>
 * Share
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
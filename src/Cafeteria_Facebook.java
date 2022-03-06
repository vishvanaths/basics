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

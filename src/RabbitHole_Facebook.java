import java.util.HashMap;
import java.util.Map;

class RabbitHole_Facebook {

    public static void main(String[] args) {
        RabbitHole_Facebook rhf = new RabbitHole_Facebook();
        System.out.println(rhf.getMaxVisitableWebpages(2, new int[]{2,1}));
    }
    public int getMaxVisitableWebpages(int N, int[] L) {

        int maxPages = 1;
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i=0; i<N; i++){
            maxPages = Math.max(maxPages, visitPages(i, L, seen));
        }
        return maxPages;
    }
    public int visitPages(int i, int[] L, Map<Integer, Integer> seen){
        if(seen.containsKey(i)){
            return seen.get(i);
        }
        seen.put(i, 1);
        int visited = visitPages(L[i]-1, L, seen) + 1;
        seen.put(i, visited);
        return visited;
    }

}


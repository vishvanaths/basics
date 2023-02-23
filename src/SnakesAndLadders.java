import java.util.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println(quickestWayUp(null, null));
    }

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<Integer, Integer> snakesMap = new HashMap<>();

        for (List<Integer> ladder : ladders) {
            ladderMap.put(ladder.get(0), ladder.get(1));
        }

        for (List<Integer> snake : snakes) {
            snakesMap.put(snake.get(0), snake.get(1));
        }

        ArrayList<Integer>[] adjacencyMatrixOfSL = new ArrayList[101];

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 6; j++) {
                int nextVal = i + j;
                if (nextVal <= 100) {
                    if (adjacencyMatrixOfSL[i] == null) {
                        adjacencyMatrixOfSL[i] = new ArrayList<>();
                    }

                    if (ladderMap.containsKey(nextVal)) {
                        adjacencyMatrixOfSL[i].add(ladderMap.get(nextVal));
                    } else if (snakesMap.containsKey(nextVal)) {
                        adjacencyMatrixOfSL[i].add(snakesMap.get(nextVal));
                    } else {
                        adjacencyMatrixOfSL[i].add(nextVal);
                    }
                }
            }
        }

        return findPath(adjacencyMatrixOfSL);
    }

    private static int findPath(List<Integer>[] adjacencyMatrixOfSL) {
        int[] board = new int[101];

        for (int i = 1; i <= 100; i++) {
            System.out.println(adjacencyMatrixOfSL[i]);
            board[i] = Integer.MAX_VALUE;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);

        board[0] = -1;
        board[1] = 0;

        while (!queue.isEmpty()) {
            int v = queue.removeFirst();

            if (adjacencyMatrixOfSL[v] != null)
                for (int cv : adjacencyMatrixOfSL[v]) {
                    if (board[v] + 1 < board[cv]) {
                        board[cv] = board[v] + 1;
                        queue.addLast(cv);
                    }
                }
        }

        return board[100] == Integer.MAX_VALUE ? -1 : board[100];
    }

}

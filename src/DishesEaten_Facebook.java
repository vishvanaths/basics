import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DishesEaten_Facebook {
    public int getMaximumEatenDishCount(int N, int[] D, int K) {
        // Write your code here
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> dishes = new HashSet<>();
        int results = 0;

        for(int i=0; i< D.length; i++){
            if(dishes.size() < K){
                results++;
                dishes.add(D[i]);
                q.offer(D[i]);
            }else{
                if(!dishes.contains(D[i])){
                    Integer dish = q.poll();
                    dishes.remove(dish);
                    results++;
                    q.offer(D[i]);
                    dishes.add(D[i]);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        DishesEaten_Facebook des = new DishesEaten_Facebook();
        System.out.println(des.getMaximumEatenDishCount(7,new int[]{1, 2, 3, 3, 2, 1}, 2));
    }
}

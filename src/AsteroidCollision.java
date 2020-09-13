import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        System.out.println(printArray(asteroidCollision(asteroids)));
    }
    private static String printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i : a){
            sb.append(i + ",");
        }
        sb.append("]");

        return sb.toString();
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length <= 0){
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0)
                stack.push(asteroids[i]);
            else if(stack.peek() <= -asteroids[i]) {
                if(stack.pop() < -asteroids[i])
                    i--;
            }
//            if(stack.empty()){
//                stack.push(asteroid);
//            }else{
//                if(asteroid < 0 && stack.peek() > 0){ //collision
//                    boolean addAsteroid = true;
//                    while(!stack.empty() && stack.peek() > 0 ){
//                        if(stack.peek() == Math.abs(asteroid)){
//                            stack.pop(); //break when same
//                            addAsteroid = false;
//                            break;
//                        }else if(stack.peek() > 0 && stack.peek() < Math.abs(asteroid)){
//                            stack.pop();
//                        }else if(stack.peek() > 0 && stack.peek() > Math.abs(asteroid)){
//                            addAsteroid = false;
//                            break;
//                        }
//                    }
//
//                    if(addAsteroid){
//                        stack.push(asteroid);
//                    }
//
//                }else{
//                    stack.push(asteroid);
//                }
//            }
        }

        return Arrays.stream(stack.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 735. Asteroid Collision
 * Medium
 *
 * 1155
 *
 * 119
 *
 * Add to List
 *
 * Share
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 */
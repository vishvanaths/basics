import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'}; 
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        if(tasks == null|| tasks.length == 0){
            return 0;
        }

        int[] characters = new int[26];

        for(char c : tasks){
            characters[c - 'A']++;
        }

        Arrays.sort(characters);
        int maxAllotments = characters[25] - 1;
        int slots = maxAllotments * n;

        for(int i=24; i >= 0 && slots >= 0; i--){
            slots -= Math.min(characters[i], maxAllotments);
        }

        return slots > 0 ? slots + tasks.length : tasks.length;
    }
}

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(12));

        System.out.println(Arrays.toString(countBits(12)));
    }
    public static int[] countBits(int num) {
        int[] i = new int[num+1];

        for(int j=0;j<=num;j++){
            if(j == 0)
                i[0] = 0;
            else if(j == 1)
                i[1] = 1;
            else if(j == 2)
                i[2] = 1;
            else if(j%2 == 0)    
                i[j] = i[j%2];
            else 
                i[j] = i[j - 1] + 1;    
        }    
        return i;
    }

    public static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
}
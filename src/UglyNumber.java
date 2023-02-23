import java.util.LinkedList;
import java.util.List;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(150));
    }

    public static int isUgly(int n) {
        List<Integer> uglyNumbers = new LinkedList<>();
        uglyNumbers.add(1);
        int next2Num = 1;
        int next3Num = 1;
        int next5num = 1;
        int i=1;
        while(i < n){
            int num2 = next2Num * 2;
            int num3 = next3Num * 3;
            int num5 = next5num * 5;
            if(num2 <= num3 && num2 <= num5){
                if(!uglyNumbers.contains(num2)){
                    uglyNumbers.add(num2);
                    i++;
                }
                next2Num++;
                continue;
            }
            if(num3 <= num2 && num3 <= num5){
                if(!uglyNumbers.contains(num3)){
                    uglyNumbers.add(num3);
                    i++;
                }
                next3Num++;
                continue;
            }
            if(num5 <= num2 && num5 <= num3){
                if(!uglyNumbers.contains(num5)){
                    uglyNumbers.add(num5);
                    i++;
                }
                next5num++;
                continue;
            }
        }
        return uglyNumbers.get(n-1);
    }
}

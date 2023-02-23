public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(2500));
        System.out.println(isPerfectSquare(63));
    }

    private static boolean isPerfectSquare(int number) {
        if(number == 1) return true;

        int left = 1;
        int right = number;

        while(left < right){
            int mid =  (left+right)/2;

            if(mid * mid == number) return true;
            else if(mid * mid < number) left =  mid + 1;
            else right =  mid -1;
        }

        if(left * left == number || right * right == number){
            return true;
        }

        return false;
    }
}

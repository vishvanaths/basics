public class PowerOfTwo_L231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int n) {
        int count =0;
        while(n != 0){
            count += n & 1;
            n = n>>1;
            if(count > 1) return false;
        }

        return count == 1;
    }
}

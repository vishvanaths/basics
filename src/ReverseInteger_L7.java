public class ReverseInteger_L7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if(x==0 || x==Integer.MIN_VALUE || x==Integer.MAX_VALUE) return 0;
        StringBuilder sb = new StringBuilder("");

        if(x < 0 ){
            sb.append("-");
            x = x * -1;
        }

        while(x != 0){
            sb.append(x%10);
            x = x/10;
        }
        String num = sb.toString();
        long l = Long.parseLong(num);
        return l > Integer.MAX_VALUE || l < Integer.MIN_VALUE ? 0 : Integer.parseInt(num)  ;
    }

}

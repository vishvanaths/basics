public class SumWithoutOperator {
    public static void main(final String[] args) {
        bitOperatorAdd();
        stringAdd();
    }

    private static void stringAdd() {
        String num1 = "1223";
        String num2 = "159";

        if(num1.length() > num2.length()){
            System.out.println(calculateSum(num1, num2));
        }else{
            System.out.println(calculateSum(num2, num1));
        }
        
    }

    private static String calculateSum(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        for(int i=a.length()-1, j=b.length()-1; i >= 0; i--, j--){
            int d1 = a.charAt(i) - '0';
            int d2 = j >= 0 ? b.charAt(j) - '0' : 0; 

            sb.append((d1+d2+carry)%10);
            carry = (d1+d2+carry)/10;
        }
        return sb.reverse().toString();
    }

    private static void bitOperatorAdd() {
        int a = 12;
        int b = 15;

        while(b != 0){
            final int sum = a ^ b;
            final int carry = (a & b) << 1;

            a = sum;
            b= carry;
        }

        System.out.println(a);
    }
}
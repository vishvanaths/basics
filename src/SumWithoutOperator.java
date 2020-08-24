public class SumWithoutOperator {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;

        while(b != 0){
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b= carry;
        }

        System.out.println(a);
    }
}
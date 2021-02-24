public class MovingAverage_L346 {
    public static void main(String[] args) {
        MovingAverage_L346 movingAverage = new MovingAverage_L346(5);
        System.out.println(movingAverage.next(12009));
        System.out.println(movingAverage.next(1965));
        System.out.println(movingAverage.next(-940));
        System.out.println(movingAverage.next(-8516));
        System.out.println(movingAverage.next(-16446));
        System.out.println(movingAverage.next(7870));
        System.out.println(movingAverage.next(25545));
        System.out.println(movingAverage.next(-21028));
        System.out.println(movingAverage.next(18430));
        System.out.println(movingAverage.next(-23464));
    }

    int windowSize = 0;
    int[] numbers;
    double windowSum;
    int fill = 0;
    /**
     * Initialize your data structure here.
     */
    public MovingAverage_L346(int size) {
        windowSize = size;
        numbers = new int[windowSize];
    }

    public double next(int val) {
        if(fill < windowSize){
            windowSum += val;
            numbers[fill++] = val;
            return windowSum/fill;
        }else{
            int position = fill % windowSize;
            int removerNum = numbers[position];
            numbers[position] = val;
            windowSum += val - removerNum;
            fill++;
            return windowSum/windowSize;
        }
    }
}

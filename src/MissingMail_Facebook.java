public class MissingMail_Facebook {
    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        double expectedProfit = 0;
        double prevDayPackages = 0;
        double lastDayProfit = 0;
        for(int i=0; i<V.length; i++){
            int currDayValue = V[i];
            double currDayProfitOnEntering = (prevDayPackages <= 0 ? 0 : (prevDayPackages - prevDayPackages * S)) + currDayValue - C;

            lastDayProfit = currDayProfitOnEntering;
            if(currDayProfitOnEntering <= 0){
                prevDayPackages +=  currDayValue;
            }else{
                expectedProfit += currDayProfitOnEntering;
                prevDayPackages = 0;
            }
        }
        return expectedProfit + lastDayProfit < expectedProfit ? expectedProfit : expectedProfit + lastDayProfit ;
    }

    public static void main(String[] args) {
        MissingMail_Facebook mmf = new MissingMail_Facebook();
        System.out.println(mmf.getMaxExpectedProfit(5, new int[]{10, 2, 8, 6, 4}, 3, 0.15));
    }
}

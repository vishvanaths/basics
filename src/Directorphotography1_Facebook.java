public class Directorphotography1_Facebook {

    public static void main(String[] args) {
        Directorphotography1_Facebook dpf = new Directorphotography1_Facebook();
        System.out.println(dpf.getArtisticPhotographCount(8, ".PBAAP.B", 1, 3));
    }
    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        // Write your code here
        int[] prefixPSum = new int[N + 1];
        int[] prefixBSum = new int[N + 1];

        prefixPSum[0] = C.charAt(0) == 'P' ? 1 : 0;
        prefixBSum[0] = C.charAt(0) == 'B' ? 1 : 0;

        int i = 1;
        for (char c : C.substring(1).toCharArray()) {
            if (c == 'P') {
                prefixPSum[i] = prefixPSum[i - 1] + 1;
            } else {
                prefixPSum[i] = prefixPSum[i - 1];
            }

            if (c == 'B') {
                prefixBSum[i] = prefixBSum[i - 1] + 1;
            } else {
                prefixBSum[i] = prefixBSum[i - 1];
            }
            i++;
        }
        int result = 0;

//        for(int i=0;i<N; i++){
//            char c =  C.charAt(i);
//            if(c == 'A'){
//                rightWindow = (bounded(i+X), bounded(i+Y+1))
//                leftWindow = (bounded(i-Y), bounded(i-X+1))
//
//                int leftPs = prefixPSum[leftWindow[1]] - prefixPSum[leftWindow[0]];
//                int rightBs = prefixBSum[rightWindow[1]] - prefixBSum[rightWindow[0]];
//                result += leftPs * rightBs;
//
//                int rightPs = prefixPSum[rightWindow[1]] - prefixPSum[rightWindow[0]];
//                int leftBs = prefixBSum[leftWindow[1]] - prefixBSum[leftWindow[0]];
//                result += leftBs * rightPs;
//            }
//
//        }


        return result;
    }
}

public class MinFlipFor01Sequence {
    public static void main(String[] args) {
        System.out.println("Min Flips required to change to [010101] from [000010] : " + minFlipsTo01Sequence("000010"));
    }

    private static int minFlipsTo01Sequence(String s) {
        return Math.min(calculateSequence(s, '0'), calculateSequence(s, '1'));
    }

    private static int calculateSequence(String s, char flipChar) {
        char currChar = flipChar;
        int flipCount = 0;
        for(char c : s.toCharArray()){
            if(currChar != c) flipCount++;

            currChar = currChar == '0' ? '1' : '0';
        }

        return flipCount;
    }
}

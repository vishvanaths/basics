public class OneEditAway {
    public static void main(String[] args) {
        String a = "pale";
        String b = "bale";

        System.out.println(isOneEditAway(a,b));
    }

    private static boolean isOneEditAway(String a, String b) {
        int differenceCount = 0;
        boolean found = false;
        for(char ac : a.toCharArray()){
            for(char bc : b.toCharArray()){
                if(ac == bc){
                    found = true;
                    break;
                }
            }
            if(!found)
            differenceCount++;
            found = false;
        }
        return differenceCount <= 1;
    }
}
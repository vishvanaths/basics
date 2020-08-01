public class OneEditAway1 {
    public static void main(String[] args) {
        String a = "pale";
        String b = "pales";

        System.out.println(isOneEditAway(a,b));
    }

    private static boolean isOneEditAway(String a, String b) {
        String bigString = a.length() > b.length() ? a : b;
        String shotString = a.equals(bigString) ? b : a;
        
        int indexb = 0, indexs=0;
        int difference = 0;
        while(indexb < bigString.length() && indexs < shotString.length()){
            if(bigString.charAt(indexb)  != shotString.charAt(indexs) ){
                if(bigString.length() == shotString.length()){
                    indexb++;
                    indexs++;
                }else{
                    indexb++;
                }
                difference++;
            }else{
                indexb++;
                indexs++;
            }
        }

        if(bigString.length() - indexb > 2){
            return false;
        }
        return difference <= 1;
    }
}
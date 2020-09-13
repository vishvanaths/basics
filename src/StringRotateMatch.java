public class StringRotateMatch {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "azonam";

        System.out.println(isRatateStringMatch(s1, s2));
    }

    private static boolean isRatateStringMatch(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        
        int pivot=s1.length() - 1;
        while(pivot >= 0 ){
            if(s1.charAt(pivot) != s2.charAt(s2.length() - 1 - pivot)){
                break;
            }else{
                pivot--;
            }
        }
        System.out.println(pivot);
        if(s1.substring(0, pivot).equals(s1.substring(pivot))){
            return true;
        }
        return false;
    }
}

/**
 * Check if a string can be obtained by rotating another string 2 places
Last Updated: 25-06-2019
Given two strings, the task is to find if a string can be obtained by rotating another string two places.
Examples:

Input: string1 = “amazon”, string2 = “azonam”
Output: Yes
// rotated anti-clockwise

Input: string1 = “amazon”, string2 = “onamaz”
Output: Yes
// rotated clockwise
 */
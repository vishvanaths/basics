public class StringRotateMatch {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "azonam";

        System.out.println(isRotatedStringMatch(s1, s2));
    }

    private static boolean isRotatedStringMatch(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
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
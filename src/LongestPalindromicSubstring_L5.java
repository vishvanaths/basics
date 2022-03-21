public class LongestPalindromicSubstring_L5 {
    Boolean[][] memo = null;
    public String longestPalindrome(String s) {
        int max = 0,start=0,end=0;
        memo=new Boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(j-i+1 > max && isPal(s,i,j)){
                    max = j-i+1;
                    start=i;
                    end = j;
                }
            }
        }

        return s.substring(start,end+1);
    }

    private boolean isPal(String s, int i, int j) {
        if(memo[i][j]!=null)
            return memo[i][j];

        if(i == j) {
            memo[i][j] = true;
            return memo[i][j];
        }


        boolean b = s.charAt(i) == s.charAt(j);

        if(j-i+1 == 2){
            if(b){
                memo[i][j] = true;
                return memo[i][j];
            }
            memo[i][j] = false;
            return memo[i][j];
        }

        memo[i][j] = b && isPal(s,i+1,j-1);

        return memo[i][j];

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_L5 l5 = new LongestPalindromicSubstring_L5();
        System.out.println("Longest Palindromic substring [babad] : " + l5.longestPalindrome("babad"));
    }
}

public class ReverseVowelsOfString_L345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels( "aA"));
    }
    public static String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        int start =0;
        int end= s.length() -1;

        while(start < end){
            while(!isVowel(s, start) && start < end){
                start++;
            }
            while(!isVowel(s, end) && start < end){
                end--;
            }
            if(start < end){
                char tmp = ch[end];
                ch[end] = ch[start];
                ch[start] = tmp;
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }

    public static boolean isVowel(String s, int index){
        char c = s.charAt(index);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

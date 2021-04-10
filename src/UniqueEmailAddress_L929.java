import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress_L929 {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            boolean ignore = false;
            boolean consider = false;
            for(int i=0; i<email.length(); i++){
                char c = email.charAt(i);
                if(c == '.' && !consider){
                    continue;
                }else if(c == '+'){
                    ignore = true;
                }else if(c == '@'){
                    sb.append('@');
                    ignore = false;
                    consider = true;
                }else if(!ignore){
                    sb.append(c);
                }
            }
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}

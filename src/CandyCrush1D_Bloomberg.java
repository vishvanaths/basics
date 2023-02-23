import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CandyCrush1D_Bloomberg {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        for(int i=0; i< 100; i++){
            m.merge("hmm", 1, Integer::sum);
        }
        System.out.println(m);
        String str = "aaabbbacd";
        System.out.println("crushed candy[" + str + "]:" + candyCrush1D(str));
    }

    public static String candyCrush1D(String crsuhit){
        char[] crushStr = crsuhit.toCharArray();
        Stack<int[]> charStack = new Stack<>();
        int[] currChar = new int[]{crushStr[0],1};

        for(int i=1;i<crushStr.length;i++){
            char c = crushStr[i];
            if(currChar[0] == c){
                currChar[1]++;
            }else if(currChar[0] != c){
                if(currChar[1] < 3){
                    charStack.push(currChar);
                    currChar = new int[]{c, 1};
                }else{
                    if(!charStack.isEmpty())
                        if(charStack.peek()[0] == c){
                            currChar = charStack.pop();
                            currChar[1]++;
                        }else{
                            currChar = new int[]{c, 1};
                        }
                    else
                        currChar = new int[]{c, 1};
                }
            }
        }

        if(currChar[1] < 3) charStack.push(currChar);

        StringBuilder sb = new StringBuilder();
        getCrushedCandy(charStack, sb);
        return sb.toString();
    }

    private static void getCrushedCandy(Stack<int[]> charStack, StringBuilder sb) {
        if(!charStack.isEmpty()){
            char ch = (char) charStack.pop()[0];
            getCrushedCandy(charStack, sb);
            sb.append(ch);
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    private static Map<Character, Character> BRACKETS_MATCH = new HashMap<>();

    public static void main(String[] arg) {
        String brackets = "{[]()[()]}";
        
        System.out.println("Braces to match " + brackets);
        System.out.println("Valid :" + validateBalancedBrackets(brackets));
    }

    private static boolean validateBalancedBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();
        BRACKETS_MATCH.put(')','(');
        BRACKETS_MATCH.put(']','[');
        BRACKETS_MATCH.put('}','{');
        for(Character c : brackets.toCharArray()){
            if(BRACKETS_MATCH.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character sc = stack.pop();
                    if(sc != BRACKETS_MATCH.get(c)){
                        return false;
                    }
                }
            }

            if(BRACKETS_MATCH.containsValue(c)){
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
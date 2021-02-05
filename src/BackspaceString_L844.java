import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class BackspaceString_L844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '#'){
                if(!sStack.isEmpty()) {
                    sStack.pop();
                }
            }else{
                sStack.push(c);
            }
        }

        Stack<Character> tStack = new Stack<>();
        for(char c: t.toCharArray()){
            if(c == '#'){
                if(!tStack.isEmpty()) {
                    tStack.pop();
                }
            }else{
                tStack.push(c);
            }
        }
        String first = Arrays.stream(sStack.toArray(new Character[0])).map(String::valueOf).collect(Collectors.joining());
        String second = Arrays.stream(tStack.toArray(new Character[0])).map(String::valueOf).collect(Collectors.joining());

        return first.equals(second);
    }
}

/**
 * 844. Backspace String Compare
 * Easy
 *
 * 2227
 *
 * 105
 *
 * Add to List
 *
 * Share
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */
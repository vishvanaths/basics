import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<String>();

        generateBrackets(n, n, "", parenthesis);

        return parenthesis;
    }

    public void generateBrackets(int openBrackets, int closeBrackets, String s, List<String> results){
        if(openBrackets == 0 && closeBrackets == 0){
            results.add(s);
            return;
        }

        if(openBrackets > 0){
            generateBrackets(openBrackets-1, closeBrackets, s + "(", results);
        }

        if(closeBrackets > 0 && closeBrackets > openBrackets){
            generateBrackets(openBrackets, closeBrackets - 1, s + ")", results);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(4));
    }
}


/***
 * 22. Generate Parentheses
 * Medium
 *
 * 11872
 *
 * 465
 *
 * Add to List
 *
 * Share
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 **/
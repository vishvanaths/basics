import java.util.Stack;

public class ScoreParentheses_L856 {
    public static void main(String[] args) {
        String S = "(()(()))";
        System.out.println(scoreOfParentheses(S));
    }

    public static int scoreOfParentheses(String S) {
        int score = 0;
        if(S == null || S.length() ==0){
            return score;
        }

        Stack<Integer> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(score);
                score = 0;
            }else{
                score = stack.pop() + Math.max(2*score, 1);
            }
        }

        return score;
    }
}

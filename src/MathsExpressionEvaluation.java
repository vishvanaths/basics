import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

public class MathsExpressionEvaluation {
    public static Map<Character, Integer> OPERATORS = new HashMap<>();
    private static Map<Character, Character> BRACKETS_MATCH = new HashMap<>();

    private static void loadPreRequicites() {
        OPERATORS.put('+', 1);
        OPERATORS.put('-', 1);
        OPERATORS.put('*', 2);
        OPERATORS.put('/', 2);
        BRACKETS_MATCH.put(')', '(');
        BRACKETS_MATCH.put(']', '[');
        BRACKETS_MATCH.put('}', '{');
    }

    private static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        loadPreRequicites();
        String infixMathsExpression = "( ( 12 + 5 * 3 ) - 4 ) + 10";
        System.out.println("Maths Expression = " + infixMathsExpression);
        // String preFixMathsExpresion = getPrefixMathsExpression(infixMathsExpression);
        // System.out.println("Prefix Expression = " + preFixMathsExpresion);
        String postFixMathsExpresion = getPostfixMathsExpression(infixMathsExpression);
        System.out.println("Postfix Expression = " + postFixMathsExpresion);
        // System.out.println("Evaluated prefix expression= " + evaluatePrefixExpression(preFixMathsExpresion));
        System.out.println("Evaluated postfix expression= " + evaluatePostfixExpression(postFixMathsExpresion));
    }

    private static String evaluatePostfixExpression(String postFixMathsExpresion) {
        String[] s = postFixMathsExpresion.split(" ");
        Stack<String> stack = new Stack<>();

        for (String op : s) {
            if (op.length() == 1 && OPERATORS.containsKey(op.charAt(0))) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(applyOp(op1, op2, op.charAt(0))));
            } else {
                stack.push(op);
            }
        }

        return stack.pop();
    }

    private static String evaluatePrefixExpression(String preFixMathsExpresion) {
        String[] s = preFixMathsExpresion.split(" ");
        Stack<String> stack = new Stack<>();

        for (int i = s.length - 1; i > -1; i--) {
            String op = s[i];
            if (op.length() == 1 && OPERATORS.containsKey(op.charAt(0))) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(applyOp(op2, op1, op.charAt(0))));
            } else {
                stack.push(op);
            }
        }

        return stack.pop();
    }

    private static String getPostfixMathsExpression(String infixMathsExpression) {
        String[] s = infixMathsExpression.split(" ");
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String c : s) {
            if (c.length() == 1) {
                Character op = c.charAt(0);
                if (OPERATORS.containsKey(op)) {
                    while (!stack.isEmpty() && OPERATORS.containsKey(stack.peek())
                            && hasHigherPrecedence(stack.peek(), op)) {
                        sb.append(stack.pop() + " ");
                    }
                    stack.push(op);
                } else if (BRACKETS_MATCH.containsKey(op)) {
                    while (!stack.isEmpty() && stack.peek() != BRACKETS_MATCH.get(op)) {
                        sb.append(stack.pop() + " ");
                    }
                    stack.pop();
                } else if (BRACKETS_MATCH.containsValue(op)) {
                    stack.push(op);
                } else {
                    sb.append(c + " ");
                }
            } else {
                sb.append(c + " ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        return sb.toString();
    }

    private static boolean hasHigherPrecedence(Character stackOp, Character op) {
        return OPERATORS.get(stackOp) >= OPERATORS.get(op);
    }

    private static String getPrefixMathsExpression(String infixMathsExpression) {
        String[] s = infixMathsExpression.split(" ");
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=s.length -1 ; i >= 0; i-- ) {
            String c = s[i];
            if (c.length() == 1) {
                Character op = c.charAt(0);
                if (OPERATORS.containsKey(op)) {
                    while (!stack.isEmpty() && OPERATORS.containsKey(stack.peek())
                            && hasHigherPrecedence(stack.peek(), op)) {
                        sb.append(stack.pop() + " ");
                    }
                    stack.push(op);
                } else if (BRACKETS_MATCH.containsValue(op)) {
                    while (!stack.isEmpty() && stack.peek() != getMatch(op)) {
                        sb.append(stack.pop() + " ");
                    }
                    stack.pop();
                } else if (BRACKETS_MATCH.containsKey(op)) {
                    stack.push(op);
                } else {
                    sb.append(c + " ");
                }
            } else {
                sb.append(c + " ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        return sb.toString();
    }

    private static Character getMatch(Character op) {
        for (Entry<Character, Character> entry : BRACKETS_MATCH.entrySet()) {
            if (entry.getValue().equals(op)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
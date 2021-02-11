import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber_L17 {

    private static final Map<Integer, String> NUMBER_STRING_MAP = new HashMap<Integer, String>() {
        {
            put(1, "");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
            put(0, "");
        }
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        if (digits.length() == 1) {
            final String dialerString = NUMBER_STRING_MAP.get(digits.charAt(0) - '0');
            for (char c : dialerString.toCharArray()) {
                combinations.add(String.valueOf(c));
            }
            return combinations;
        }

        letterCombiner(digits, 0, "", combinations);

        return combinations;
    }

    private static void letterCombiner(String digits, int index, String s, List<String> combinations) {
        if (s.length() == digits.length()) {
            combinations.add(s);
            return;
        }

        final String dialerString = NUMBER_STRING_MAP.get(digits.charAt(index) - '0');
        for (int i = 0; i < dialerString.length(); i++) {
            letterCombiner(digits, index+1, s + dialerString.charAt(i), combinations);
        }
    }
}

import java.util.*;

public class RepeatedDNASequences_L183 {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences_MinMap(s));
        System.out.println(findRepeatedDnaSequences_Rolling(s));
    }

    public static List<String> findRepeatedDnaSequences_MinMap(String s) {
        final int L = 10;
        List<String> repeatedSequence = new ArrayList<>();
        if (s.length() <= L) {
            return repeatedSequence;
        }

        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String subString = s.substring(i, i + 10);
            seen.put(subString, seen.getOrDefault(subString, 0) + 1);
            if (seen.get(subString) == 2) {
                repeatedSequence.add(subString);
            }
        }
        return repeatedSequence;
    }

    //TODO: Need More work
    public static List<String> findRepeatedDnaSequences_Rolling(String s) {
        final int L = 10;
        List<String> repeatedSequence = new ArrayList<>();
        if (s.length() <= L) {
            return repeatedSequence;
        }
        final int alphabets = 4;
        final Map<Character, Integer> CONVERSION_MAP = new HashMap() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        int[] nums = new int[s.length()];
        int hashCode = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            nums[i] = CONVERSION_MAP.get(s.charAt(i));
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> strings = new HashSet<>();
        for(int tracker = 0; tracker < nums.length-L+1; tracker++){
            if(tracker == 0){

            }else{

            }

        }
        repeatedSequence.addAll(strings);
        return repeatedSequence;
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class HackerRankSampleTests {
    public static void main(String[] args) {
        //String
        System.out.println("****** String Manipulations **** \nInPlace reverse [helium]: " + inPlaceStringReverse("helium"));
        System.out.println("Duplicate chars [hello]: " + printDuplicateChars("hello"));
        System.out.println("Check Anagram [mary, army]: " + checkIfAnagram("mary", "army"));
        System.out.println("Check Anagram [roomy, mommy]: " + checkIfAnagram("roomy", "mommy"));
        System.out.println("Permutations Of All strings: " + permutationsOfAllStrings("mature"));
        System.out.println("Recursion reverse [helium]: " + recursionReverse("helium", 0));
        System.out.println("Number of Vowels in String [australia]: " + getNumberOfVowels("australia"));
        System.out.println("Count occurrence of 'a' in [australia]: " + countOccurrence("australia", 'a'));
        System.out.println("First Non repeating character [australia] : " + fistNonRepeatingCharacter("australia"));
        System.out.println("Reverse words in sentence [Lake is so beautiful and tranquil]  : " + reverseWords("Lake is so beautiful and tranquil"));
        System.out.println("All permutations of word  : " + allPermutations("abc"));
        System.out.println("Check If Palindrome [crop]  : " + checkPalindrome("india"));
        System.out.println("Length Of Longest Substring without repeating char  : " + longestSubStringWithoutRepeat("crop"));
        System.out.println("Max occurring character [Propellers] : " + maxOccurringCharacter("Propellersp"));
        System.out.println("Remove char from String [proper, e] : " + removeCharFromString("proper", 'e'));

        //Array
        System.out.println("\n\n*******Arrays ******\nFind missing number in an array [1,2,3,5] : " + findMissingNumber(new int[] {1,2,3,5}));
        System.out.println("Find missing number in an array [1,2,3,5] : " + findMissingNumberFormula(new int[] {1,2,3,5}));
        System.out.println("Find pairs with matching sum : " + findPairWithMatchingSum(new int[] {1,2,3,5}, 5));
        System.out.println("Remove duplicates from array : " + removeDuplicates(new int[]{3,5,4,8,4,9,3,5}));
        System.out.println("Reverse array : " + reverseArray(new int[]{3,5,4,8,4,9,3,5}));
        System.out.println("Find top two integers in an array : " + findTopTwo(new int[]{3,5,4,8,4,9,3,5}));
    }

    private static String removeCharFromString(String s, char removeChar) {
        int index = s.indexOf(removeChar);

        if(index != -1){
            return s.substring(0, index) + s.substring(index+1);
        }else{
            return s;
        }
    }

    private static String maxOccurringCharacter(String s) {
        PriorityQueue<CharValue> charValues = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
        Map<Character, CharValue> chars = new HashMap<>();
        for(char c : s.toLowerCase().toCharArray()){
            if (chars.containsKey(c)) {
                CharValue charValue = chars.get(c);
                charValue.val = charValue.val + 1;
                chars.put(c, charValue);
            }else{
                chars.put(c, new CharValue(c, 1));
            }

        }

        for(Map.Entry<Character, CharValue> entry : chars.entrySet()){
            charValues.add(entry.getValue());
        }

        return charValues.poll().c + "";
    }

    static class CharValue{
        public char c;
        public int val;

        public CharValue(char c, int val){
            this.c = c;
            this.val = val;
        }
    }

    private static int longestSubStringWithoutRepeat(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        if(s.length() == 1) return 1;

        Set<Character> chars = new HashSet<>();
        int end = 0;
        int start = 0;
        while(end < s.length()){
            if(!chars.contains(s.charAt(end))){
                chars.add(s.charAt(end));
                result = Math.max(chars.size(), result);
                end++;
            }else{
                chars.remove(s.charAt(start));
                start++;
                break;
            }
        }

        return result;
    }

    private static Boolean checkPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i=0, j=chars.length-1;

        while(i<j){
            if(chars[i] != chars[j]){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    private static Set<String> allPermutations(String word) {
        Set<String> result = new HashSet<>();
        recurseToFindPermutationsOfWord(word, "", result);
        return result;
    }

    private static void recurseToFindPermutationsOfWord(String word, String subString, Set<String> result) {
        if(word.isEmpty()){
            result.add(subString);
        }else{
            for(int i=0;i<word.length();i++){
                recurseToFindPermutationsOfWord(word.substring(0,i) + word.substring(i+1),subString + word.charAt(i), result);
            }
        }
    }

    private static List<Integer> findTopTwo(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i : nums){
            if(max1 < i){
                max2 = max1;
                max1 = i;
            }else if (max2 < i) {
                max2 = i;
            }
        }
        result.add(max1);
        result.add(max2);

        return result;
    }

    private static String reverseArray(int[] nums) {
        int i=0;
        int j=nums.length -1;

        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        return Arrays.toString(nums);
    }

    private static Set<Integer> removeDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        if(nums == null || nums.length == 0) return result;
        if(nums.length == 1) {result.add(nums[0]); return result;}
        Arrays.sort(nums);

        for(int i = 0; i < nums.length;){
            int currNum = nums[i];
            boolean skipNum = false;
            if(i+1 < nums.length){
                int j=i+1;
                for( ; j < nums.length; j++){
                    if(nums[j] == currNum){
                        skipNum = true;
                    }
                    if(nums[j] != currNum){
                        break;
                    }
                }
                i=j;
            }else {
                i++;
            }

            if(!skipNum){
                result.add(currNum);
            }
        }
        return result;
    }

    private static Set<String> findPairWithMatchingSum(int[] nums, int target) {
        Set<String> result = new HashSet<>();
        Set<Integer> otherHalf = new HashSet<>();

        for(int number : nums){
            int required =  target - number;
            if(!otherHalf.contains(required)){
                otherHalf.add(number);
            }else{
                result.add(number + " " + required);
            }
        }
        return result;
    }

    private static int findMissingNumberFormula(int[] numbers) { //summation formula n * n+1/2 works subtract all nums and the remains the missing number. Length of array is missing a number so add 1
        int n = numbers.length+1;
        int sum = n * (n+1) / 2;
        for(int number : numbers){
            sum = sum - number;
        }
        return sum;
    }

    private static int findMissingNumber(int[] numbers) {
        int total = 1;

        for(int i=2; i < numbers.length + 2; i++){
            total = total + i;
            total = total - numbers[i-2];
        }
        return total;
    }

    private static String reverseWords(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        Collections.reverse(words);
        return words.stream().collect(Collectors.joining(" "));
    }

    private static String fistNonRepeatingCharacter(String s) {
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        return "" + characterCount.entrySet().stream().filter(cEntry -> cEntry.getValue() < 2).findFirst().get().getKey();
    }

    private static int countOccurrence(String s, char a) {
        if(s == null || s.length() == 0 ) return 0;

        int occurrences = 0;
        for(char c : s.toCharArray()){
            if(c == a) occurrences++;
        }
        return occurrences;
    }

    private static int getNumberOfVowels(String s) {
        if(s == null || s.length() == 0) return 0;
        int vowels = 0;
        for(char c : s.toCharArray()){
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowels++;
                    break;
                default :
                    continue;
            }
        }
        return vowels;
    }

    private static String recursionReverse(String s, int index) {
        if(s.length() - 1 == index){
            return s.charAt(index) + "";
        }
        return  recursionReverse(s, index+1) + s.charAt(index);
    }

    private static Set<String> permutationsOfAllStrings(String s) {
        Set<String> samples = new HashSet<>();
        if(s == null || s.length() == 0) return samples;
        if(s.length() == 1) {samples.add(s); return samples;}
//
//        for(int i=0; i<)
        return null;
    }

    private static Boolean checkIfAnagram(String s1, String s2) {
        if(s1 == null && s2 == null) return true;
        if((s1 != null && s2 == null) ||  (s1 == null && s2 != null)) return false;
        if(s1.length() != s2.length()) return false;

        char[] firstCharArr = s1.toCharArray();
        StringBuilder sbSecond = new StringBuilder(s2);
        for(char c : firstCharArr){
            int index = sbSecond.indexOf(c + "");
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }

        return sbSecond.length() > 0 ? false : true;
    }

    private static Set<Character> printDuplicateChars(String s) {
        Map<Character, Integer> duplicatesMap = new HashMap<>();
        if(s == null || s.length() <= 1) {
            return new HashSet<>();
        }

        for(char c : s.toCharArray()){
            duplicatesMap.put(c, duplicatesMap.getOrDefault(c, 0) + 1);
        }

        return duplicatesMap.entrySet().stream().filter(keyVal -> keyVal.getValue() > 1).map(keyVal -> keyVal.getKey()).collect(Collectors.toSet());
    }

    private static String inPlaceStringReverse(String s) {
        if(s == null || s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        int i=0, j=s.length()-1;

        while(i < j){
            swapChars(chars, i, j);

            i++;
            j--;
        }

        return new String(chars);
    }

    private static void swapChars(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

public class MaxLengthOfConcatenatedString_L1239 {
    public static void main(String[] args) {
        String[] array = new String[]{"un","iq","ue"};
        System.out.println(maxLength(array));
    }

    public static int maxLength(String[] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return array[0].length();
        }
        int[] length = new int[1];
        findMaxLength(array, 0, "", length);
        return length[0];
    }

    private static void findMaxLength(String[] array, int i, String s, int[] length) {
        if(i >= array.length){
            return;
        }
        
        String newStr = s + array[i];
        boolean isUnique = isUniqueCharacterString(newStr);
        if(!isUnique){
            return;
        }
        if(isUnique && length[0] < newStr.length()){
            length[0] = newStr.length();
        }
        findMaxLength(array, i+1, newStr, length);
        findMaxLength(array, i+1, s, length);
    }

    private static boolean isUniqueCharacterString(String newStr) {
        int[] charArray = new int[26];
        for(char c : newStr.toCharArray()){
            charArray[c - 'a']++;
            if(charArray[c - 'a'] > 1){
                return false;
            }
        }
        return true;
    }

}

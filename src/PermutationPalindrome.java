import java.util.Scanner;

public class PermutationPalindrome {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String testString = scanner.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
        int[] charsArray = new int[26];
        for(char a : testString.toCharArray()){
            if(charsArray[a - 'a'] == 1){
                charsArray[a - 'a'] = 0;
            }else{
                charsArray[a - 'a'] = 1;
            }

            
        }

        int counts = 0;
        for(int i : charsArray){
            if(counts > 1){
                System.out.println("Not a pelindrome with permutation");
                return;
            }else{
                counts += i;
            }
        }

        System.out.println("Is Pelindrome with permutation");
    }
}
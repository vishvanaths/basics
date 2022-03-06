import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ScoreBoardInference1_Facebook {

    public int getMinProblemCount(int N, int[] S) {
        Map<Integer, Integer> questionOccurance = new HashMap<>();
        Arrays.sort(S);

        for(int i=S.length -1; i>=0; i--){
            int score = S[i];

            int twos = score/2;
            int ones= score%2;
            if(twos != 0){
                if(!questionOccurance.containsKey(2)){
                    questionOccurance.put(2, twos);
                }else{
                    if(questionOccurance.get(2) < twos){
                        questionOccurance.put(2, twos);
                    }
                }
            }
            if(ones != 0){
                if(!questionOccurance.containsKey(1)){
                    questionOccurance.put(1, ones);
                }else{
                    if(questionOccurance.get(1) < ones){
                        questionOccurance.put(1, ones);
                    }
                }
            }
        }

        int results = 0;
        for(Map.Entry<Integer, Integer> entry : questionOccurance.entrySet()){
            results += entry.getValue();
        }
        return results;
    }

    public static void main(String[] args) {
        ScoreBoardInference1_Facebook scf = new ScoreBoardInference1_Facebook();
        System.out.println(scf.getMinProblemCount(4, new int[] {4, 3, 3, 4}));
    }
}

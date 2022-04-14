import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_LE118 {
    public static void main(String[] args) {
        PascalsTriangle_LE118 ps = new PascalsTriangle_LE118();
        ps.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int i=0;
        while(i < numRows){
            List<Integer> ints = new ArrayList<>();
            if(i==0) {
                ints.add(1);
            }else if(i==1){
                ints.add(1);
                ints.add(1);
            }else{
                List<Integer> prev = result.get(i-1);
                ints.add(1);
                for(int j=0; j<prev.size()-1; j++){
                    ints.add(prev.get(j) + prev.get(j+1));
                }
                ints.add(1);
            }
            result.add(ints);
            i++;
        }
        return result;
    }
}

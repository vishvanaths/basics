import java.util.Stack;

public class WaterBetweenPillars {
    public static void main(String[] args) {
        draw(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("Water filled : " + trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap1(int[] heights) {
        Stack<Integer> pillarsStack = new Stack<>();
        int result = 0;
        int i = 0;
        while (i < heights.length) {
            int pillar = heights[i];
            if (pillarsStack.empty()) {
                pillarsStack.push(pillar);
                i++;
                continue;
            } else {
                //
            }

            i++;
        }

        return result;
    }

    public static int trap(int[] heights) {
        if (heights.length == 0) return 0;

        int count = 0;
        int maxHeightIdx = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[maxHeightIdx] < heights[i]) maxHeightIdx = i;
        }

        //System.out.println("MAX IDX: " + maxHeightIdx);

        int front;
        int back;
        for (front = 0; front < maxHeightIdx; front++) {
            // check if currently a peak
            if (heights[front] > heights[front + 1]) {
                //System.out.println("VALLEY START: " + front);
                // count rain until reach the same height or maxHeightIdx
                back = front + 1;
                while (back <= maxHeightIdx && heights[front] > heights[back]) {
                    //System.out.println("Water at " + back + ": " + (heights[front] - heights[back]));
                    count += heights[front] - heights[back];
                    back++;
                }
                front = back - 1;
                //System.out.println("VALLEY END: " + front);
            }
        }


        for (back = heights.length - 1; back > maxHeightIdx; back--) {
            // check if currently a peak
            if (heights[back] > heights[back - 1]) {
                //System.out.println("VALLEY START: " + back);
                // count rain until reach the same height or maxHeightIdx
                front = back - 1;
                while (front >= maxHeightIdx && heights[back] > heights[front]) {
                    //System.out.println("Water at " + front + ": " + (heights[back] - heights[front]));
                    count += heights[back] - heights[front];
                    front--;
                }
                back = front + 1;
                //System.out.println("VALLEY END: " + back);
            }
        }

        return count;

    }

    public static void draw(int[] heights) {
        StringBuilder sb = new StringBuilder();
        int max = heights[0];
        sb.append("\n");
        for (int i = 1; i < heights.length; i++) {
            max = Math.max(max, heights[i]);
        }
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < heights.length; j++) {
                if(heights[j] >= i){
                    sb.append("[] ");
                }else {
                    sb.append("   ");
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < heights.length; i++) {
            sb.append("__ ");
        }
        sb.append("\n");
        for (int i = 0; i < heights.length; i++) {
            if(i < 9){
                sb.append(" " + (i+1) + " ");
            }else{
                sb.append(" " + (i+1));
            }
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
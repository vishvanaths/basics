public class MinStackImplementationOptimized {
    public static void main(String[] args) {
        MinStackImplementationOptimized min = new MinStackImplementationOptimized();
        Stack minStack = min.new Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-8);
        minStack.push(-4);
        System.out.println("stack : " + minStack);
        System.out.println("Min : " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("stack : " + minStack);
        System.out.println("Top : " + minStack.top()); // return 0
        minStack.pop();
        System.out.println("stack : " + minStack);
        System.out.println("Min : " + minStack.getMin()); // return -2
        // System.out.println(minStack);
    }

    class Stack{
        private int[]  array = new int[100];
        private int top = 0;
        private int minIndex = 0;

        public int pop(){
            if(array[top - 1] == array[minIndex]){
                recalculateMinIndex(top - 1);
            }
            return array[top--];
        }

        public int top(){
            return array[top-1];
        }

        public void push(int item){
            if(array[minIndex] > item){
                minIndex = top;
            }
            array[top++] = item;
        }

        private void recalculateMinIndex(int till) {
            minIndex = 0;
            for(int i=0; i<till ;i++){
                if(array[minIndex] > array[i]){
                    minIndex = i;
                }
            }
        }

        public int getMin() {
            return array[minIndex];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<top;i++){
                sb.append("->" + array[i]);
            }
            return sb.toString();
        }
    }

}

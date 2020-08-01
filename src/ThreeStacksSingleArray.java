public class ThreeStacksSingleArray {
    public static void main(String[] args) {
        //consider using stack id A, B , C
    }
}
class StackArray{
    public static int STACK_SIZE = 9;

    int[] arrayStack = new int[STACK_SIZE];
    int stackATop = 0, stackBTop = STACK_SIZE/3, stackCTop = 2 * STACK_SIZE / 3;

    public void push(String stackId, int element){
        switch(stackId){
            case "A" : {
                if(stackATop < STACK_SIZE/3){
                    arrayStack[stackATop++] = element;
                }else{
                    createNewStackAndCopy();
                }
            }
            break;
            case "B" : {
                if(stackATop < 2 * STACK_SIZE/3){
                    arrayStack[stackATop++] = element;
                }
            }
            break;
            case "C" : {
                if(stackATop <  STACK_SIZE){
                    arrayStack[stackATop++] = element;
                }
            }
            break;
        }
    }

    private void createNewStackAndCopy() {
        // int[] newStack = new int[STACK_SIZE * 3];
        //arrayStack = 
    }

    public int pop(String stackId){
        switch(stackId){
            case "A" : {
                return arrayStack[stackATop--];
            }
            case "B" : {
                return arrayStack[stackBTop--];
            }
            case "C" : {
                return arrayStack[stackCTop--];
            }
            default : 
                return 0;
        }
    }
}
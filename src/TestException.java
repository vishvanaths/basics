import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException {
    public static void main(String[] args){
        try {
            myMethod();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void myMethod() throws FileNotFoundException {
        try{
            throw new IOException("Couldn't Perform IO");
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            throw new FileNotFoundException("File Not found");
        }
    }
}

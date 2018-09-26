package Chapter11;
import static java.lang.Thread.currentThread;
public class mainThreadClassLoader {

    public static void main(String[] args){
        System.out.println(currentThread().getContextClassLoader());
    }
}

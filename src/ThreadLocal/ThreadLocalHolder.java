package ThreadLocal;

public class ThreadLocalHolder {

    public static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static final void set(byte [] b){
        threadLocal.set(b);
    }

    public static final void clear(){
        threadLocal.set(null);
    }
}
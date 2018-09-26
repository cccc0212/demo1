package ClassLoader;

public class NameSpace {

    public static void main(String[] args)throws ClassNotFoundException{
        ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("ClassLoader.MyClassLoaderTest");
        Class<?> bClass = classLoader.loadClass("ClassLoader.MyClassLoaderTest");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass==bClass);
    }
}

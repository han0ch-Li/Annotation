package Reflection;

//测试类什么时候会初始化
public class ClassInitialization {
    static {
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        Son son = new Son();
        //2.反射也会产生主动引用
        Class.forName("Reflection.Son");
        //不会产生类的引用的方法
        System.out.println(Son.b);//通过子类引用父类的静态变量，不会引起子类的初始化
        Son[]sons = new Son[5];//通过数组定义类引用，不会引起类的任何初始化
        System.out.println(Son.M);//常量不会引起类的任何初始化


    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }

}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}

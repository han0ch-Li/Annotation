package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射动态创建对象
public class CreateObject {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("Reflection.User");
        //构造一个对象
        User user = (User)c1.newInstance();//本质是调用了User的无参构造器
        System.out.println(user);
        //1. 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
        User user1 = (User)constructor.newInstance("Vic",001,18);
        System.out.println(user1);
        //2. 通过反射调用普通方法
        User user2 = (User)c1.newInstance();
        //先通过反射获取方法
        Method method = c1.getDeclaredMethod("setName",String.class);
        //激活
        method.invoke(user2,"hanoch");
        System.out.println(user2.getName());
        //3. 通过反射操作属性
        User user3 = (User)c1.newInstance();
        Field field = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要通过setAccessible关闭程序的安全检测
        field.setAccessible(true);
        field.set(user3,"Raylene");
        System.out.println(user3.getName());
        //Method,Field,Constructor都有setAccessible方法

    }
}

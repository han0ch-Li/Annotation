package Annotation;

import java.lang.annotation.*;

//测试元注解
public class AnnotationDemo {
    public static void main(String[] args) {

    }

    //注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotation(name = "Vic",age = 24,id = 1,schools = {"MIT"})
    public void test(){

    }

    //如果注解只有一个参数，参数名可设为value,在使用注解时可以省略value这个词
    @MyAnnotation2("Vic")
    public void test2(){

    }

}

//定义一个注解
@Target(value = {ElementType.METHOD,ElementType.TYPE})//仅可在方法和类中使用该注解
@Retention(value = RetentionPolicy.RUNTIME)//该注解仅可在运行时有效
@Documented //表示是否将我们的注解生成在JavaDoc中
@Inherited //子类可以继承父类的注解
@interface MyAnnotation{
    //注解的参数：参数类型+参数名（）；
    String name() default ""; //默认值为空，代表可以不写参数
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools() default {"NUS","NTU"};
}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}


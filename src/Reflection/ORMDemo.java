package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class ORMDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("Reflection.Employee");
        //通过反射获取注解
        Annotation[]annotations = c1.getAnnotations();
        for (Annotation annotation:annotations) {
            System.out.println(annotation);
        }
        //获得注解的value的值
        TableHanoch tableHanoch = (TableHanoch) c1.getAnnotation(TableHanoch.class);
        String value = tableHanoch.value();
        System.out.println(value);

        //获得类指定的注解
        Field field = c1.getDeclaredField("name");
        FieldHanoch fieldHanoch = field.getAnnotation(FieldHanoch.class);
        System.out.println(fieldHanoch.columnName());
        System.out.println(fieldHanoch.type());
        System.out.println(fieldHanoch.length());

    }
}

@TableHanoch("db_employee")
class Employee{
    @FieldHanoch(columnName = "db_name",type = "varchar",length = 100)
    private String name;
    @FieldHanoch(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldHanoch(columnName = "db_id",type = "int",length = 2)
    private int id;

    public Employee() {

    }

    public Employee(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableHanoch{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldHanoch{
    String columnName();
    String type();
    int length();
}



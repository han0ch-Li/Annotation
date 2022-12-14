package Reflection;

public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        //通过反射获取类的Class对象
        Class c1 = Class.forName("Reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("Reflection.User");
        Class c3 = Class.forName("Reflection.User");

        //一个类在内存中只有一个Class对象,所以所有的hashcode值都一样
        //一个类在加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode() == c3.hashCode());

    }
}

//定义一个实体类
class User{
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

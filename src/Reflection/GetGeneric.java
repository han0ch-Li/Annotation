package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GetGeneric {

    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<User,String> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GetGeneric.class.getMethod("test01",Map.class,List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType:genericParameterTypes) {
            System.out.println("#"+genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[]actualTypeArguments =  ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument:actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        Method method2 = GetGeneric.class.getMethod("test02",null);
        Type genericReturnType = method2.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[]actualTypeArguments =  ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument:actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }


}

package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        test();

    }

    public static void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> c = methodClass.class;
        Object object = c.newInstance();
//        Method[] methods = c.getMethods();
//        Method[] declaredMethods = c.getDeclaredMethods();
//        Method method = c.getMethod("add", int.class, int.class);
//        System.out.println("getMethods获取的方法");
//        for (Method method1 : methods) {
//            System.out.println(method1);
//        }
//        System.out.println("getDeclaredMethods获取的方法");
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
//        }

        Field[] fields = c.getFields();
        System.out.println("1111111111111");
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println("22222222222222");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }


    }

    class methodClass {
        public final int fuck = 3;

        public int add(int a, int b) {
            return a + b;
        }

        public int sub(int a, int b) {
            return a + b;
        }
    }
}

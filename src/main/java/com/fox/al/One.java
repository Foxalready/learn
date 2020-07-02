package com.fox.al;

import sun.reflect.Reflection;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2018/10/12
 * @Version: [v1.0]
 */
public class One {

    public static void main(String[] args) {
        One one = new One();
        int cal = one.cal(5);
        System.out.println(cal);
        int con = one.con();
        System.out.println(con);
        System.out.println(Integer.MAX_VALUE);
    }

    private int con() {

        Class<?> callerClass = Reflection.getCallerClass();
        String name = callerClass.getName();
        System.out.println(name);

        int i = 1;
        int a = i << 30;
        return a;
    }

    private int cal(int n) {
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; i++) {
            j = 1;
            for (; j <= n; j++) {
                sum = sum + i * j;
            }
        }
        return sum;
    }

//    private int cal(int n) {
//        int sum = 0;//1
//        int i = 1;//1
//        for (; i <= n; i++) {//n
//            sum = sum + i;//n
//        }
//        return sum;
//    }
}

package com.fox;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/5/13
 * @Version: [v1.0]
 */
public class Tester {

    public static void main(String[] args) {


//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            Integer next = iterator.next();
            System.out.println(next);
        }


//        int a = 1;
//
//        int i = a % 1000 == 0 ? a / 1000 : a / 1000 + 1;
//        System.out.println(i);


//        Student student = null;
//
////        new Tuple2
//
////        student.setAge(10L);
////        student.setName("fox");
//
//        Student student1 = Optional.ofNullable(student).orElseGet(() ->{
//            Student student2 = new Student();
//            student2.setName("already");
//            student2.setAge(20L);
//            return student2;
//        });
//        System.out.println(student1.getAge());
    }
}

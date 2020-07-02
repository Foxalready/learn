package com.fox.guava;

import java.util.Optional;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/5/10
 * @Version: [v1.0]
 */
public class Pra {
    public static void main(String[] args) {

        Optional<Integer> possible = Optional.of(6);
        if (possible.isPresent()){
            System.out.println(possible.isPresent());
            System.out.println(possible.get());
        }


        if (null instanceof Object){
            System.out.println("111111");
        }else {
            System.out.println("222222222");
        }
    }
}

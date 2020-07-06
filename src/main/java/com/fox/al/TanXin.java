package com.fox.al;

import com.google.inject.internal.cglib.core.$DuplicatesPredicate;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/7/6
 * @Version: [v1.0]
 */
public class TanXin {

    public static void main(String[] args) {

        TanXin tanXin = new TanXin();
        int tanxin = tanXin.tanxin(456);
        System.out.println(tanxin);

    }

    private int tanxin(int pay) {
        int[] count = {1, 2, 2, 3, 3};
        int[] value = {1, 5, 10, 50, 100};

        int result = 0;
        int i = 4;
        while (i >= 0) {

            int v = pay % value[i];
            int c = pay / value[i];

            if (c <= count[i]) {
                result = result + c;
                pay = v;
            } else {
                result = result + count[i];
                pay = v + (c - count[i]) * value[i];
            }

            if (v == 0) {
                break;
            } else {
                i--;
            }

        }

        if (pay > 0) {
            return -1;
        }

        return result;

    }
}

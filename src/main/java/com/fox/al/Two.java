//package com.fox.al;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Description: [描述此类]
// * @Author: gaoyimin
// * @CreateDate: 2018/10/15
// * @Version: [v1.0]
// */
//public class Two {
//    public static void main(String[] args) {
//
//        Two two = new Two();
//
//        int[] array = new int[10];
//        int count = 0;
//
//        two.insert(array, count, 10);
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("----------" + array[i]);
//        }
//    }
//
//    private void insert(int[] array, int count, int val) {
//        if (count == array.length) {
//            int sum = 0;
//            for (int i = 0; i < array.length; i++) {
//                sum = sum + array[i];
//            }
//            array[0] = sum;
//            count = 1;
//        }
//        array[count] = val;
//        count++;
//    }
//
//    //n表示数组array的长度
//    private int find(int[] array, int n, int x) {
//        int i = 0;
//        int pos = -1;
//        for (; i < n; i++) {
//            if (array[i] == x) {
//                pos = i;
//            }
//            return pos;
//        }
//        return pos;
//    }
//
//    private void print(int n) {
//        int i = 0;
//        int[] a = new int[n];
//        for (; i < n; i++) {
//            a[i] = i * i;
//        }
//
//        for (i = n - 1; i >= 0; i--) {
//            System.out.println(i);
//        }
//    }
//
//    private int multi(int m, int n) {
//        int sum = 0;
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; i++) {
//                sum = sum + j;
//            }
//        }
//        return sum;
//    }
//
//    private int cal(int m, int n) {
//        int sum1 = 0;
//        int i = 1;
//        for (; i < m; i++) {
//            sum1 = sum1 + i;
//        }
//
//        int sum2 = 0;
//        for (int j = 1; j < n; j++) {
//            sum2 = sum2 + j;
//        }
//
//        return sum1 + sum2;
//    }
//}

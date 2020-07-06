package com.fox.al.find;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/7/2
 * @Version: [v1.0]
 */
public class FindDemo {

    public static void main(String[] args) {
        FindDemo findDemo = new FindDemo();
//        int[] arr = new int[]{6, 0, 3, 7, 2, 1, 23, 46, 30, 59};
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int erfen = findDemo.erfen(arr, 11);
        System.out.println(erfen);

        double pow = findDemo.pow(10.0, 4);
        System.out.println(pow);

    }

    /**
     * 二分查找
     * 如果能查找，把所在的位置index返回；
     * 如果查不到，则返回 -1
     */
    private int erfen(int[] arr, int n) {
        int l = arr.length - 1;
        int min = 0;

        while (min <= l) {
            int mid = (l + min) / 2;
            if (n == arr[mid]) {
                return mid;
            } else if (n < arr[mid]) {
                l = mid - 1;
            } else if (n > arr[mid]) {
                min = mid + 1;
            }
        }
        return -1;
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double t = pow(x, n / 2);
        if (n % 2 == 0) {
            return x * t * t;
        }
        return t * t;
    }
}

package com.fox.stack;

/**
 * @Description: [数组栈]
 * @Author: gaoyimin
 * @CreateDate: 2019/7/16
 * @Version: [v1.0]
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private int l;

    /**
     * 栈中数组的个数
     */
    private int count;

    /**
     * 数组
     */
    private Object[] items;

    public ArrayStack(int l) {
        this.l = l;
        this.count = 0;
        this.items = new Object[l];
    }

    //入栈
    private void push() {

    }

    //出栈
    private Object pop() {

        return null;
    }

}

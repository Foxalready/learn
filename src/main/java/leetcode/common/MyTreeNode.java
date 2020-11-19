package leetcode.common;

import java.io.Serializable;

public class MyTreeNode implements Serializable {

    public int value;

    public MyTreeNode left;

    public MyTreeNode right;

    public MyTreeNode(int value) {
        this.value = value;
    }

    public MyTreeNode(int value, MyTreeNode left, MyTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }
}

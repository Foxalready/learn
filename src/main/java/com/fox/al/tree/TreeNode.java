package com.fox.al.tree;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/6/30
 * @Version: [v1.0]
 */
public class TreeNode {

    public int value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

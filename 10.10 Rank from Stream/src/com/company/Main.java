package com.company;

import sun.reflect.generics.tree.Tree;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TreeNode root = new TreeNode(1);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(3);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(5);
        TreeNode temp5 = new TreeNode(6);
        TreeNode temp6 = new TreeNode(7);
        TreeNode temp7 = new TreeNode(8);

        TreeNode temp8 = new TreeNode(9);

        root.left = temp1;
        root.right = temp2;
        temp2.left = temp3;
        temp2.right = temp7;
        temp3.left = temp4;
        temp3.right = temp5;
        temp4.right = temp6;

        System.out.println(commonAncestor(root, temp6, temp8).val);

    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int k) {
            val = k;
            left = null;
            right = null;
        }
    }


    static TreeNode commonAncestor(TreeNode node, TreeNode a, TreeNode b) {
        if (node == null) return null;

        if (node == a) return a;

        if (node == b) return b;

        TreeNode left = commonAncestor(node.left, a, b);
        TreeNode right = commonAncestor(node.right, a, b);

        if (left == null) return right;
        if (right == null) return left;

        return node;
    }
}

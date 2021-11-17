package com.dmitrydunai;

import java.util.Stack;

public class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            n1.val += n2.val;
            if(n1.left == null){
                n1.left = n2.left;
            } else if(n1.left != null && n2.left != null){
                s1.push(n1.left);
                s2.push(n2.left);
            }
            if(n1.right == null){
                n1.right = n2.right;
            } else if(n1.right != null && n2.right != null){
                s1.push(n1.right);
                s2.push(n2.right);
            }
        }
        return root1;
    }
}
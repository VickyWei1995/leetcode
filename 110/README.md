# 110 Balanced Binary Tree

https://leetcode.com/problems/balanced-binary-tree/



## 思路

判断一个二叉树是否平衡。树平衡的定义是，对于树上的任意节点，其两侧节点的最大深度的差值不得大于1。 递归。左子树平衡，右子树平衡，且左子树深度和右子树深度差值小于2

## Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(treeHeight(root.left) - treeHeight(root.right))<=1;
        
    }
    
    private int treeHeight(TreeNode root) {
        return root == null?0:1+Math.max(treeHeight(root.left), treeHeight(root.right));
    }
}
```


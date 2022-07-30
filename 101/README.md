# 101 Symmetric Tree

https://leetcode.com/problems/symmetric-tree/



## 思路

判断一个二叉树是否对称。判断一个树是否对称等价于判断左右子树是否对称。笔者一般习惯将判断两个子树是否相等或对称类型的题的解法叫做“四步法”：（1）如果两个子树都为空指针，则它们相等或对称（2）如果两个子树只有一个为空指针，则它们不相等或不对称（3）如果两个子树根节点的值不相等，则它们不相等或不对称（4）根据相等或对称要求，进行递归处理。

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.right, right.left) && helper(left.left, right.right);
    }
}
```


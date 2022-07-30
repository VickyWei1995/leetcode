# 437 Path Sum III

https://leetcode.com/problems/path-sum-iii/



## 思路

给定一个整数二叉树，求有多少条路径节点值的和等于给定值。递归每个节点时，需要分情况考虑：（1）如果选取该节点加入路径，则之后必须继续加入连续节点，或停止加入节点（2）如果不选取该节点加入路径，则对其左右节点进行重新进行考虑。



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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return beginWithRoot(root,targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int beginWithRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = root.val == targetSum ? 1: 0;
        res += beginWithRoot(root.left, targetSum-root.val) ;
        res += beginWithRoot(root.right, targetSum-root.val) ;
        return res;
    }
}
```


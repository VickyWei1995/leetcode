# 102 Binary Tree Level Order Traversal

https://leetcode.com/problems/binary-tree-level-order-traversal/



## 思路

队列实现层次遍历。队列不为空的时候，进行遍历，poll 元素，加入层次遍历的数组，并且新增left 和 right 进入队列。



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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            int length = q.size();
            for (int i=0; i<length; i++) {
                TreeNode temp = q.poll();
                oneLevel.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            res.add(oneLevel);
        }
        return res;
        
    }
}
```


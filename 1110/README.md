# 1110 Delete Nodes And Return Forest

https://leetcode.com/problems/delete-nodes-and-return-forest/



## 思路

给定一个整数二叉树和一些整数，求删掉这些整数对应的节点后，剩余的子树。递归遍历，对于根节点被删除的情况，其2棵子树有可能成为新的子树。如果左节点也被删除了，那左节点就不应该进入森林；如果右节点被删除，则右节点不应该进入森林。这里遍历的时候，需要返回一个状态值，标记当前节点是否被删除用该状态值判断是否需要进入森林

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: to_delete) {
            numSet.add(num);
        }
        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = helper(null,root,result,numSet, false);
        if (temp != null) {
            result.add(temp);
        }
        return result;
    }
    
    private TreeNode helper(TreeNode parent, TreeNode root, List<TreeNode> res, Set<Integer> numSet, boolean isLeft) {
        if (root == null) {
            return null;
        }
        // 利用 null 进行标记，返回非null的时候，说明该子节点没有被删除
        // 这个helper 函数如果返回void的话，就可能导致误加入子节点
        TreeNode left = helper(root, root.left, res, numSet, true);;
        TreeNode right = helper(root, root.right, res, numSet, false);;
        if (numSet.remove(root.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            root.left = null;
            root.right = null;
            root = null;
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        return root;
    }
}
```


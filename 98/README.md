# 98 Validate Binary Search Tree

https://leetcode.com/problems/validate-binary-search-tree/



## 思路

判断一棵树是否为二叉查找树。思路一，判断其中序遍历是否有序；思路二，递归判断子树的时候传入最小、最大值进行限制。

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        for (int i=1; i<inorderList.size(); i++) {
            if (inorderList.get(i-1) >= inorderList.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }
}
```


package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

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
        public List<PathSumII.TreeNode> delNodes(PathSumII.TreeNode root, int[] to_delete) {
            Set<Integer> numSet = new HashSet<>();
            for (int num: to_delete) {
                numSet.add(num);
            }
            List<PathSumII.TreeNode> result = new ArrayList<>();
            PathSumII.TreeNode temp = helper(null,root,result,numSet, false);
            if (temp != null) {
                result.add(temp);
            }
            return result;
        }

        private PathSumII.TreeNode helper(PathSumII.TreeNode parent, PathSumII.TreeNode root, List<PathSumII.TreeNode> res, Set<Integer> numSet, boolean isLeft) {
            if (root == null) {
                return null;
            }
            // 利用 null 进行标记，返回非null的时候，说明该子节点没有被删除
            // 这个helper 函数如果返回void的话，就可能导致误加入子节点
            PathSumII.TreeNode left = helper(root, root.left, res, numSet, true);;
            PathSumII.TreeNode right = helper(root, root.right, res, numSet, false);;
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
}

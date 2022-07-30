package LeetCode;

public class SymmetricTree {


    class Solution {
        public boolean isSymmetric(PathSumII.TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        private boolean helper(PathSumII.TreeNode left, PathSumII.TreeNode right) {
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
}

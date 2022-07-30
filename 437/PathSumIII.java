package LeetCode;

public class PathSumIII {


    class Solution {
        public int pathSum(PathSumII.TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            return beginWithRoot(root,targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        }

        private int beginWithRoot(PathSumII.TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int res = root.val == targetSum ? 1: 0;
            res += beginWithRoot(root.left, targetSum-root.val) ;
            res += beginWithRoot(root.right, targetSum-root.val) ;
            return res;
        }
    }
}

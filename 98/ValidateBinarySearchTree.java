package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(PathSumII.TreeNode root) {
            List<Integer> inorderList = new ArrayList<>();
            inorder(root, inorderList);
            for (int i=1; i<inorderList.size(); i++) {
                if (inorderList.get(i-1) >= inorderList.get(i)) {
                    return false;
                }
            }
            return true;
        }

        private void inorder(PathSumII.TreeNode root, List<Integer> inorderList) {
            if (root == null) {
                return;
            }
            inorder(root.left, inorderList);
            inorderList.add(root.val);
            inorder(root.right, inorderList);
        }
    }
}

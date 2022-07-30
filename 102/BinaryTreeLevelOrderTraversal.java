package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(PathSumII.TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<PathSumII.TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                List<Integer> oneLevel = new ArrayList<>();
                int length = q.size();
                for (int i=0; i<length; i++) {
                    PathSumII.TreeNode temp = q.poll();
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
}

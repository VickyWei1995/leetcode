package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String test = "aab";
        Solution s = new Solution();
        s.partition(test);
    }
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> subRes = new ArrayList<>();
            helper(s, 0, subRes, res);
            return res;
        }

        private void helper(String s, int startIndex, List<String> subRes, List<List<String>> res) {
            if (startIndex == s.length()) {
                List<String> dst = new ArrayList<>(subRes);
                res.add(dst);
                return;
            }
            for (int i=startIndex; i<s.length(); i++) {
                if (!isPalindrome(s, startIndex, i)) {
                    continue;
                }
                subRes.add(s.substring(startIndex, i+1));
                int curIndex = subRes.size()-1;
                helper(s, i+1, subRes, res);
                subRes.remove(curIndex);
            }
        }

        private boolean isPalindrome(String s, int begin, int end) {
            while (begin <= end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
        }
    }
}

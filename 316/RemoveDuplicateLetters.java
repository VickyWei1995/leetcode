package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String test = "bcabc";
        Solution s = new Solution();
        String res = s.removeDuplicateLetters(test);
        System.out.println(res);
    }

    static class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            boolean[] visited = new boolean[26];
            List<Character> res = new ArrayList<>();
            res.add('0');
            for (int i=0; i<s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                count[charIndex]++;
            }

            for (int i=0; i<s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                count[charIndex]--;
                if (visited[charIndex]) {
                    continue;
                }
                while (s.charAt(i) < res.get(res.size() -1) && count[res.get(res.size() -1)-'a']>0) {
                    visited[res.get(res.size() -1)-'a'] = false;
                    res.remove(res.size()-1);
                }
                res.add(s.charAt(i));
                visited[charIndex] = true;
            }
            res.remove(0);
            return res.stream().map(String::valueOf).collect(Collectors.joining());
        }

        private void checkMove(char c, List<Character> res) {
            int findIndex = res.indexOf(c);
            if (findIndex == res.size() - 1) {
                return;
            }
            int bigIndex = -1, smallIndex = -1;
            for (int i=findIndex+1; i<res.size(); i++) {
                if (res.get(i) < c && smallIndex < 0) {
                    smallIndex = i;
                } else if (res.get(i) > c && bigIndex < 0) {
                    bigIndex = i;
                }
            }
            if (smallIndex >= 0 && (bigIndex > smallIndex || bigIndex < 0)) {
                res.remove(findIndex);
                res.add(c);
            }
            return;
        }
    }
}

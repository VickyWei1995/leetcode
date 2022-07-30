package LeetCode;

public class MaximumProductOfWordLengths {
    class Solution {
        public int maxProduct(String[] words) {
            int[] masks = new int[words.length];
            int result = 0;
            for (int j=0; j<words.length; j++) {
                int mask = 0;
                String word = words[j];
                for (int i=0; i<word.length(); i++) {
                    int moveNum = word.charAt(i) - 'a';
                    mask |= (1 << moveNum);
                }
                masks[j] = mask;
                for (int k=0; k<j;k++) {
                    if ((masks[k] & masks[j]) == 0) {
                        result = Math.max(result, word.length() * words[k].length());
                    }
                }
            }
            return result;
        }
    }
}

package LeetCode;

public class LongestSubstringAtLeastKRepeatingCharacters {
    class Solution {
        public int longestSubstring(String s, int k) {
            int i =0;
            int n = s.length();
            int resLen = 0;
            while (i+k <= n) {
                int[] charCount = new int[26];
                int mask = 0;
                int nextBeginIndex = i;
                for (int j=i; j<n; j++) {
                    int charIndex = s.charAt(j) - 'a';
                    charCount[charIndex] += 1;
                    if (charCount[charIndex] >= k)
                        mask &= ~(1 << charIndex);
                    else
                        mask |= (1 << charIndex);
                    if (mask == 0) {
                        resLen = Math.max(resLen, j-i+1);
                        nextBeginIndex = j;
                    }
                }
                i = nextBeginIndex + 1;
            }
            return resLen;
        }
    }
}

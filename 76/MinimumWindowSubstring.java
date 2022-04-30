import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "bba";
        String t = "ab";
        Solution solution = new Solution();
        System.out.print(solution.minWindow(s,t));
    }

    static class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> charCounts = new HashMap<>();   // 统计字符的出现次数
            for (int i=0; i<t.length(); i++) {
                if (!charCounts.containsKey(t.charAt(i))) {
                    charCounts.put(t.charAt(i), 0);
                }
                charCounts.put(t.charAt(i), charCounts.get(t.charAt(i))+1);
            }

            int r=0, l=0, minSize = s.length() + 1, minL = 0, count =0;
            for (; r<s.length(); r++) {
                if (charCounts.containsKey(s.charAt(r))) {
                    charCounts.put(s.charAt(r), charCounts.get(s.charAt(r))-1);
                    if (charCounts.get(s.charAt(r)) >= 0) {
                        ++count;
                    }
                }
                while (count == t.length()) {
                    if (r-l+1 < minSize) {
                        minSize = r-l+1;
                        minL = l;
                    }
                    if (charCounts.containsKey(s.charAt(l))) {
                        charCounts.put(s.charAt(l), charCounts.get(s.charAt(l))+1);
                        if (charCounts.get(s.charAt(l)) > 0) {
                            --count;
                        }
                    }
                    l++;
                }
            }
            return minSize > s.length() ? "" : s.substring(minL, minL+minSize);
        }
    }

}

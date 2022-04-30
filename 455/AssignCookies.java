import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {

    }

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int result = 0;
            int i=0, j= 0;
            while(i < g.length && j < s.length) {
                if (s[j] >= g[i]) {
                    i++;
                    j++;
                    result++;
                } else {
                    j++;
                }
            }
            return result;
        }
    }
}

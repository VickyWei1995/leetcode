package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] sMap = new int[256];
            int[] tMap = new int[256];
            for (int i=0; i<s.length(); i++) {
                if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                    return false;
                }
                sMap[s.charAt(i)] = tMap[t.charAt(i)] =i+1;
            }
            return true;
        }
    }
}


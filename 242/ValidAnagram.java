package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character,Integer> sMap = new HashMap<>();
            for (char c = 'a'; c<='z'; c++) {
                sMap.put(c,0);
            }
            for (int i=0; i<s.length();i++) {
                int cur = sMap.get(s.charAt(i)) + 1;
                sMap.put(s.charAt(i), cur);
            }

            for (int i=0; i<t.length(); i++) {
                int cur = sMap.get(t.charAt(i)) - 1;
                sMap.put(t.charAt(i), cur);
            }
            for (char key: sMap.keySet()) {
                if (sMap.get(key) != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

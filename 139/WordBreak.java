package LeetCode;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String test = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Solution s = new Solution();
        s.wordBreak(test, wordDict);
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] tempResult = new boolean[s.length()];
            for(int i=0; i<s.length();i++) {
                if (wordDict.contains(s.substring(0,i+1))) {
                    tempResult[i] = true;
                    continue;
                }
                for (int j=i-1; j>=0; j--) {
                    if (tempResult[j] && wordDict.contains(s.substring(j+1,i+1))) {
                        tempResult[i] = true;
                        break;
                    }
                }
            }
            return tempResult[s.length()-1];
        }
    }

}

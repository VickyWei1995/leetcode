package LeetCode;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String beginWord = "ymain";
        String endWord = "oecij";
        String[] tempWords = {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj"};
        List<String> wordList = Arrays.asList(tempWords);
        int res = s.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            boolean[] visited = new boolean[wordList.size()];
            int res = ladderHelper(beginWord, endWord, wordList, visited);
            return res;
        }

        private int ladderHelper(String beginWord, String endWord, List<String> wordList, boolean[] visited) {
            List<Integer> curChangeToList = new ArrayList<>();
            for (int i=0; i<wordList.size(); i++) {
                if (visited[i]) {
                    continue;
                }
                String curWord = wordList.get(i);
                if (beginWord == curWord) {
                    visited[i] = true;
                    continue;
                }
                if (diffOneChar(beginWord, curWord)) {
                    curChangeToList.add(i);
                }
            }
            if (curChangeToList.size() <= 0) {
                return wordList.size() + 1;
            }
            int res = wordList.size() + 1;
            for (int i=0; i<curChangeToList.size(); i++) {
                int nextWordIndex = curChangeToList.get(i);
                visited[nextWordIndex] = true;
                if (wordList.get(nextWordIndex) == endWord) {
                    res = 0;
                    break;
                }
                int tempRes = ladderHelper(wordList.get(nextWordIndex), endWord, wordList, visited);
                res = Math.min(res, tempRes);
                visited[nextWordIndex] = false;
            }
            return res + 1;
        }

        private boolean diffOneChar(String beginWord, String curWord) {
            if (beginWord.length() != curWord.length()) {
                return false;
            }
            int diff = 0;
            for (int i=0; i<curWord.length(); i++) {
                if (beginWord.charAt(i) != curWord.charAt(i)) {
                  diff++;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution2 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord.length() != endWord.length()) {
                return 0;
            }
            Queue<String> q = new LinkedList<>();
            q.add(beginWord);
            List<String> tempWordList = new ArrayList<>(wordList);
            tempWordList.remove(beginWord);
            int length = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                length++;
                for (int k=0; k<size; k++) {
                    String curWord = q.poll();
                    char[] curWordChars = curWord.toCharArray();
                    for (int i=0; i<curWordChars.length; i++) {
                        char oldChar = curWordChars[i];
                        for (char j='a'; j<='z'; j++) {
                            if (j == curWordChars[i]) {
                                continue;
                            }
                            curWordChars[i] = j;
                            String modifyStr = String.valueOf(curWordChars);
                            if (tempWordList.indexOf(modifyStr) >= 0) {
                                if (modifyStr.equals(endWord)) {
                                    return length;
                                }
                                q.add(modifyStr);
                                tempWordList.remove(modifyStr);
                            }
                        }
                        curWordChars[i] = oldChar;
                    }
                }
            }
            return 0;
        }
    }
}

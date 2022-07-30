package LeetCode;

public class NumberOfProvinces {
    public static void main(String[] args) {

    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int result = 0;
            for (int i=0; i<isConnected.length; i++) {
                for (int j=i; j<isConnected.length; j++) {
                    if (isConnected[i][j] == 1) {
                        dfs(isConnected, i);
                        result += 1;
                    }
                }
            }
            return result;
        }

        private void dfs(int[][] isConnected, int currentIndex) {
            for (int i=0; i<isConnected.length; i++) {
                if (isConnected[currentIndex][i] == 1) {
                    isConnected[currentIndex][i] = 0;
                    dfs(isConnected, i);
                }
            }
        }
    }
}

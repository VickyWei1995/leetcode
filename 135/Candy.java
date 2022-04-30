import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] test = {1, 0,2};
        Solution s = new Solution();
        s.candy(test);

    }

    static class Solution {
        public int candy(int[] ratings) {
            int[] candyCountArray = new int[ratings.length];
            Arrays.fill(candyCountArray, 1);
            for (int i=1; i<candyCountArray.length; i++) {
                if (ratings[i] > ratings[i-1]) {
                    candyCountArray[i] = candyCountArray[i-1] + 1;
                }
            }
            for (int i=ratings.length-1; i>0; i--) {
                if (ratings[i-1] > ratings[i]) {
                    candyCountArray[i-1] = Math.max(1 + candyCountArray[i],candyCountArray[i-1]);
                }
            }
            System.out.print(Arrays.toString(candyCountArray));
            return Arrays.stream(candyCountArray).sum();
        }
    }
}

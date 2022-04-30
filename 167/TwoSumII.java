public class TwoSumII {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int leftIndex = 0, rightIndex = numbers.length-1;
            while(numbers[leftIndex] + numbers[rightIndex] != target) {
                if (numbers[leftIndex] + numbers[rightIndex] > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
            return new int[]{leftIndex+1, rightIndex+1};
        }
    }
}

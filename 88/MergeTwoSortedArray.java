public class MergeTwoSortedArray {
    public static void main(String[] args) {

    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = m-- + n-- -1;
            while (m>=0 && n>=0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[index] = nums1[m];
                    m--;
                } else {
                    nums1[index] = nums2[n];
                    n--;
                }
                index--;
            }
            while (n >=0) {
                nums1[index--] = nums2[n--];
            }
            return;
        }
    }


}

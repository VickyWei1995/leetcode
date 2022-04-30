public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] test = {
                {1,2},{2,3},{3,4},{1,3}
        };
        Solution s = new Solution();
        s.eraseOverlapIntervals(test);
    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            // 选取结尾小，且不重叠的区间
            int endInt = intervals[0][1];
            int result = 0;
            for (int i=1; i<intervals.length; i++) {
                if (intervals[i][0] >= endInt) {
                    endInt = intervals[i][1];
                } else {
                    result++;
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public int eraseOverlapIntervals(int[][] intervals) {
            java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            // 选取开头大，且不重叠的区间
            int beginInt = intervals[0][0];
            int result = 0;
            for (int i=1; i<intervals.length; i++) {
                if (intervals[i][1] <= beginInt) {
                    beginInt = intervals[i][0];
                } else {
                    result++;
                }
            }
            return result;
        }
    }

}

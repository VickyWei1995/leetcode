package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] testCase = {1,3,4,2};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(testCase, 6)));

    }
}

class Solution {
    // hashmap
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int[] result = {-1,-1};
        HashMap<Integer,Integer> m1=new HashMap<Integer,Integer>();  
        for (int i=0; i<nums.length; i++) {
            int sub = target - nums[i];
            if (m1.containsKey(nums[i])) {
                return new int[] {i, m1.get(nums[i])};
            }
            m1.put(sub, i);
        }
        return result;
    }
}

class Solution1 {
    // 先排序再找
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int[] result = {-1,-1};
        // quick sort
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        quickSort(sortNums, 0, nums.length-1);
        System.out.println(Arrays.toString(sortNums));
        int left =0;
        int right = sortNums.length -1;
        while(left < right) {
            if (sortNums[right] + sortNums[left] > target) {
                right--;
            }
            else if (sortNums[right] + sortNums[left] < target) {
                left++;
            }
            else {
                break;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == sortNums[left] && result[0] ==-1) {
                result[0] = i;
            } else if (nums[i] == sortNums[right]) {
                result[1] = i;
            }
        }
        return result;
    }

    private int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 根据基准值即arr[low]，将数组分为2部分。pivotIndex为分割index 
            int pivotIndex = partion(arr, low, high);
            System.out.println(pivotIndex);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    private int partion(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotIndex = left+1;
        for (int i=left+1; i<=right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotIndex);
                pivotIndex += 1;
            }
            System.out.println(Arrays.toString(arr));
        }
        swap(arr, left, pivotIndex-1);
        return pivotIndex-1;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
        return;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n =4;
        int k=2;
        Solution s = new Solution();
        s.combine(n, k);
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (k == 1) {
                for (int i=1; i<=n; i++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    result.add(temp);
                }
                return result;
            }
            // 递归时会进行n-1 所以这里需要针对n==k进行处理,避免n<k的情况
            if (k == n) {
                List<Integer> temp = new ArrayList<>();
                for (int i=1; i<=n; i++) {
                    temp.add(i);
                }
                result.add(temp);
                return result;
            }

            List<List<Integer>> subResult = combine(n-1, k-1);
            result = combine(n-1, k);
            Iterator<List<Integer>> listIterator = subResult.iterator();
            while (listIterator.hasNext()) {
                List<Integer> subList = listIterator.next(); // must be called before you can call i.remove()
                subList.add(n);
                result.add(subList);
            }
            return result;
        }
    }

    static class Solution2 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (k == 1) {
                for (int i=1; i<=n; i++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    result.add(temp);
                }
                return result;
            }
            List<List<Integer>> subResult = combine(n, k-1);
            for (int i=1; i<=n; i++) {
                Iterator<List<Integer>> listIterator = subResult.iterator();
                while (listIterator.hasNext()) {
                    List<Integer> subList = listIterator.next(); // must be called before you can call i.remove()
                    if (subList.contains(i)) {
                        listIterator.remove();
                    } else {
                        List<Integer> copy = new ArrayList<>(subList);
                        copy.add(i);
                        result.add(copy);
                    }
                }
            }
            return result;
        }
    }

    static class Solution3 {

    }
}

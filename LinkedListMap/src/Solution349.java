
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/// Leetcode 349. Intersection of Two Arrays
/// https://leetcode.com/problems/intersection-of-two-arrays/description
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2) {
            if(set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
       Solution349 solution = new Solution349();
       int[] nums1 = {4, 9, 5};
       int[] nums2 = {9, 4, 9, 8, 4};
       int[] result = solution.intersection(nums1, nums2);
       System.out.println(Arrays.toString(result));
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/// Leetcode 350. Intersection of Two Arrays II
/// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num)) {
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] result = (new Solution350()).intersect(num1, num2);
        System.out.println(Arrays.toString(result));
    }

}

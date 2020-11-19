package leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 911;
        TwoSum obj = new TwoSum();
        int[] ints = obj.twoSum(nums, target);
        System.out.println(JSON.toJSONString(ints));

    }

    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;

    }


}

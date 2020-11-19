package leetcode.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeSum.threeSum(nums);
//        lists = lists.stream().distinct().collect(Collectors.toList());
        List<List<Integer>> lists = threeSum.binary(nums);
        System.out.println(JSON.toJSONString(lists));

    }

    private List<List<Integer>> binary(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //排除，已经组合过一次的组合。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        //增大left
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);
                    do {
                        right--;
                    } while (nums[right] == nums[right + 1] && left < right);
                    continue;
                }
                //过大，需要进行缩小
                if (sum > target) {
                    //减小right
                    do {
                        right--;
                    } while (nums[right] == nums[right + 1] && left < right);
                    continue;
                }
                //过小，需要进行扩大
                do {
                    left++;
                } while (nums[left] == nums[left - 1] && left < right);
            }

        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return result;

    }

}

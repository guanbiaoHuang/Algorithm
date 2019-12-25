import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15.三数之和
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 三数之和，化为双数之和，遍历数组，将数组中的数作为两数之和的答案的相反数，即完成转变
     */
    private List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == nums || nums.length < 3) {
            return result;
        }
        //先将数组排序，可实现双指针
        Arrays.sort(nums);
        int l, r;
        //外层循环固定两数之和的答案
        for (int i = 0; i < nums.length; i++) {
            //去掉重复的的两数之和答案
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //从左到右，如果当前已经大于0，那么就坑定没有指定三个数
            if (nums[i] > 0) {
                break;
            }
            r = nums.length - 1;
            l = i + 1;
            //内层循环，双指针
            while (l < r) {
                //三数之和大于0，右边指针往左移
                if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                    //三数之和小于0，右边指针往右移
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    //相等时添加到链表中
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去除相同的答案
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    //继续遍历剩余的数看是否右其他答案满足
                    l++;
                    r--;
                }
            }

        }
        return result;
    }

}

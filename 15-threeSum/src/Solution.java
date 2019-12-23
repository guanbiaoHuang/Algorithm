/**
 * LeetCode 15.三数之和
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }

    /**
     * 参考整数转罗马数字
     */
    private int romanToInt(String s) {
        int ans = 0;
        int index = 0;
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        while (index < s.length() - 1) {
            for (int i = 0; i < 13; i++) {
                if (s.startsWith(reps[i], index)) {
                    ans += nums[i];
                    index += reps[i].length();
                }
            }
        }
        return ans;
    }

}

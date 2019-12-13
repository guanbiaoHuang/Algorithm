/**
 * LeetCode 12.整数转罗马数字
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(2313));
    }

    private String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        //根据题目所述得出的字符对应表，从大到小排列
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //遍历字符表
        for (int i = 0; i < 13; i++) {
            //如果当前数字大于表中的某个数字(由于从大到小排序，所以肯定是数字能大于表中数字中的最大数字)
            while (num >= nums[i]) {
                //当前数字减去转换的数字
                num -= nums[i];
                //罗马数字添加转换的数字
                sb.append(reps[i]);
            }
        }
        //返回罗马数字
        return sb.toString();
    }

}

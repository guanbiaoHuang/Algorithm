/**
 * LeetCode 11.盛水最多的容器
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //暴力破解法
    private int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - 1) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    private int maxArea2(int[] height) {
        return 0;
    }
}

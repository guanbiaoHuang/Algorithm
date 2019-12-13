/**
 * LeetCode 11.盛水最多的容器
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 暴力破解法
     */
    private int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - 1) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 双指针法
     * 理解：两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     * 所以两个指针，一个头一个尾，然后较短向较高的一端移动
     */
    private int maxArea2(int[] height) {
        int start = 0, end = height.length - 1;
        int maxarea = (end - start) * Math.min(height[start], height[end]);
        while (start != end) {
            //较短一端向高的一端移动
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
            //获取当前最大面积
            maxarea = Math.max(maxarea, (end - start) * Math.min(height[start], height[end]));
        }
        return maxarea;
    }
}

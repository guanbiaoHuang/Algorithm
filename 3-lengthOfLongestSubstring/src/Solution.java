import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复子串
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abc"));
    }

    /**
     * 暴力法破解
     * 外层循环遍历整个数组， 内层循环从外层循环遍历的位置往前遍历，并把遍历过的字符放进hashMap中
     * 使用containsKey判断内层循环当前遍历的字符是否已经在内层循环中遍历过。如果有则跳出循环，当前最长字符长度即为外层下标减去内层下标
     */
    private int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>(28);
        char[] arr = s.toCharArray();
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int j;
            for (j = i; j >= 0; j--) {
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], 1);
                } else {
                    break;
                }
            }
            map.clear();
            dp[i] = Math.max(dp[i - 1], i - j);
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length() - 1];
    }
}

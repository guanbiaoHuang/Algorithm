import java.util.HashMap;
import java.util.HashSet;
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
        int ans = 1;
        Map<Character, Integer> map = new HashMap<>(28);
        char[] arr = s.toCharArray();
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
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

    /**
     * 滑动窗口法
     * 列入对于abca，i=0，j=1，j向右滑动，最大满足为abc，j=3时，窗口为abca不满足要求
     * 为继续满足，i向右滑动一位，此时满足，然后j继续向右滑动，重复此动作即可
     */
    private int lengthOfLongestSubstring2(String s) {
        //ans为结果，i，j分别表示滑动窗口的左边界和右边界
        int ans = 0, i = 0, j = 0;
        //set用于表示滑动窗口内容
        HashSet<Character> set = new HashSet<>(28);
        //重复动作直至左边界或右边界到达字符串边界
        while (i < s.length() && j < s.length()) {
            //滑动窗口不包含当前右边界值，则添加到滑动窗口中，并向右滑动，即j++
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                //比较当前窗口大小和历史最大获得当前经历过的区域最大
                ans = Math.max(ans, j - i);
            } else {
                //滑动窗口包含重复，左边界滑动，即i++，并将左边界值从窗口中移除
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口法优化。
     * 使用HashMap记录每一个ci'fu
     */
    private int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(28);
        //窗口右边界每次都滑动
        for (int j = 0, i = 0; j < n; j++) {
            //如果map中包含当前右边界指向字符
            //则比较重复字符与左边界的大小，把i更新为最大的那个
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //获取答案
            ans = Math.max(ans, j - i + 1);
            //将有边界字符放入map中，或更新重复字符的下标
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

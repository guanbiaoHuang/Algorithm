/**
 * LeetCode 14.最长公共前缀
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution());
    }

    /**
     * 暴力法破解
     */
    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int count = 0;
        boolean isMatch = true;
        while (true) {
            try {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].charAt(count) != strs[i - 1].charAt(count)) {
                        isMatch = false;
                        break;
                    }
                }
                if (!isMatch) {
                    break;
                }
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }

        }
        return strs[0].substring(0, count);
    }


    /**
     * 水平扫描法
     */
    private String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                //如果不是以该前缀开头，则截短前缀，继续验证，直至prefix为空
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}

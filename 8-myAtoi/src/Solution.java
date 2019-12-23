/**
 * LeetCode 8.字符串转换整数
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("456234355565"));
    }

    private int myAtoi(String str) {
        //效率比遍历低，但是方便，左右清空
        str = str.trim();
        //判断清空后的串是否为空
        if (str.length() == 0) {
            return 0;
        } else {
            char[] arr = str.toCharArray();
            int i = 0, answer = 0;
            //首位为+、-号的情况
            if (arr[0] == '+' || arr[0] == '-') {
                for (i = 1; i < arr.length; i++) {
                    if (arr[i] < 48 || arr[i] > 57) {
                        break;
                    }
                }
                //判断是否只包含+、-
                if (i == 1) {
                    return 0;
                }
                //超出Int转换长度处理
                try {
                    answer = Integer.parseInt(str.substring(0, i));
                } catch (NumberFormatException e) {
                    return arr[0] == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                return answer;
            //首位为数字的情况
            } else if (arr[0] >= 48 && arr[0] <= 57) {
                for (i = 1; i < arr.length; i++) {
                    if (arr[i] < 48 || arr[i] > 57) {
                        break;
                    }
                }
                //超出Int转换长度处理
                try {
                    answer = Integer.parseInt(str.substring(0, i));
                } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE;
                }
                return answer;
            //首位为其他字符的情况
            } else {
                return 0;
            }
        }

    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6.Z字变换
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution());
    }

    private String convert(String s, int numRows) {
        //如果转换的字符串行数低于2，则返回原来的串
        if (s.length() < 2) {
            return s;
        }
        //使用长度为行数的链表记录每一行的串
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }
        //
        int flag = -1;
        int i = 0;
        //遍历字符串，会发现每个字符所在行数会有0增大到numRows-1，再有numRows-1减小至0，重复这个过程直至遍历完数组
        for (char c : s.toCharArray()) {
            //为第i行添加当前遍历的字符
            sbList.get(i).append(c);
            //如果i碰到边界，即0或者numRows-1，则将flag翻转，原因是直接可以通过加法进行i的递增和递减工作
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            //切换行
            i += flag;
        }
        //汇总答案
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbList) {
            result.append(sb);
        }
        return result.toString();

    }

}

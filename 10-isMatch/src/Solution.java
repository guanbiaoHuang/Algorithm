/**
 * LeetCode 10.正则表达式匹配
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution());
    }

    /**
     * 回溯法，将大问题化小问题
     */
    private boolean isMatch(String s, String p) {
        //判断s是否为空，s为空则p为空时返回true
        if (s.isEmpty()) {
            return p.isEmpty();
        } else {
            //s不为空时判断字符串的第一位是否匹配（若p为空则不匹配）
            //两者都不为空时匹配的条件：p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'
            //两个条件满足，说明第一位字符串匹配到
            boolean isMatched = !p.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            //判断正则表达式的下一是否为*，防止数组越界，先判断正则表达式的长度是否满足
            if (p.length() >= 2 && p.charAt(1) == '*') {
                //第二位是*的情况下，有两种可能
                //第一种第一次没有匹配到，则由于*代表0或多，所以可以忽略p的前两位，进行下一次匹配（特殊情况，即可以丢弃p的前几位，进行新一次的匹配，仍算作第一次匹配）。
                //第二种是第一次怕匹配到，则s指向下一位，由于*代表0或多，所以p不用改变。
                return isMatch(s, p.substring(2)) || (isMatched && isMatch(s.substring(1), p));
                //没有*号的情况
            } else {
                //无论是有没有*，都得满足这一次和下一次的结果都为true，即全部匹配
                return isMatched && isMatch(s.substring(1), p.substring(1));
            }
        }
    }


}

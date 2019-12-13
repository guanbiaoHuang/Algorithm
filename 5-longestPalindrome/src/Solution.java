/**
 * LeetCode 5.最长回文子串
 * 算法关联：动态规划
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("12345"));
    }

    private String longestPalindrome(String s) {
        String str = s;
        char[] arr = s.toCharArray();
        int maxLength = 0;
        int nowLength = 0;
        int preCount = 0;
        for(int i=0; i<arr.length-1; i++){
            //回文串长度为偶数的情况，如abba，bb
            if(arr[i]==arr[i+1]){
                preCount=0;
                nowLength=2;
                for(int j=1; j<=i&&i+j+1<arr.length; j++){
                    if(arr[i-j]==arr[i+j+1]){
                        nowLength+=2;
                        preCount++;
                    }else {
                        break;
                    }
                }
                if(nowLength>maxLength){
                    //preCount记录中心扩散往前的遍历长度
                    str = s.substring(i-preCount,i-preCount+nowLength);
                    maxLength = nowLength;
                }
            }
            //无论回文串长度是否奇数还是偶数，都要处理的代码。因为有可能存在 aaa的情况，如果单纯认为偶数的情况那么为二，实际为三
            preCount=0;
            nowLength=1;
            for(int j=1; j<=i&&i+j<arr.length; j++){
                if(arr[i-j]==arr[i+j]){
                    nowLength+=2;
                    preCount++;
                }else {
                    break;
                }
            }
            //比较当前最大长度串长度，和以前最大串长度
            if(nowLength>maxLength){
                //preCount记录中心扩散往前的遍历长度
                str = s.substring(i-preCount,i-preCount + nowLength);
                maxLength = nowLength;
            }

        }
        return  str;
    }
}

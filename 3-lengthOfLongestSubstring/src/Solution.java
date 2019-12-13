import java.util.Map;

import	java.util.HashMap;
/**
 * 最长不重复子串
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Map<Character,Integer> map = new HashMap<Character, Integer> ();
        char[] arr = s.toCharArray();
        dp[0] = 1;
        map.put(arr[0],1);
        for(int i=1; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                dp[i]=Math.max(i-s.lastIndexOf(arr[i],i),dp[i-1]);
                System.out.println(i+":"+dp[i]);
            }
        }

        return dp[s.length()-1];
    }
}

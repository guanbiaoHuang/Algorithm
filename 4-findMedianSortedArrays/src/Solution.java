/**
 * LeetCode 4.寻找两个有序数组的中位数，要求时间复杂度O(log（m+n）)
 * 算法关联：动态规划
 *
 * @author Jason
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{6,7,8}));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //两个数组的总长度
        int totalLen = nums1.length + nums2.length;
        //新建数组，长度位总长度减半再加一，原因总长度若是奇数，则中位数刚好为最后一位数，若为偶数则为最后两位数的平均数
        int[] newArr = new int[totalLen / 2 + 1];
        int i = 0, j = 0;
        int count = 0;
        //外循环判断数组是否存满，count为数组下标，最长为newArr.length-1，但由于count每次加一，所以判断条件如此
        while (count != newArr.length) {
            //两个数组按顺序遍历，比谁小，谁小谁下标加一，并把当前数字加到新数组中
            if (i != nums1.length && j != nums2.length && nums1[i] < nums2[j]) {
                newArr[count] = nums1[i];
                count++;
                i++;
            } else if (i != nums1.length && j != nums2.length && nums1[i] > nums2[j]) {
                newArr[count] = nums2[j];
                count++;
                j++;
            } else if (i == nums1.length) {
                //对一个数组已经遍历到底但还没有遍历到中位数进行处理
                newArr[count] = nums2[j];
                j++;
                count++;
            } else {
                newArr[count] = nums1[i];
                i++;
                count++;
            }
        }
        //总长度若是奇数，则中位数刚好为最后一位数，若为偶数则为最后两位数的平均数
        if (totalLen % 2 == 1) {
            return newArr[newArr.length - 1];
        } else {
            return (double) (newArr[newArr.length - 1] + newArr[newArr.length - 2]) / 2;
        }


    }
}

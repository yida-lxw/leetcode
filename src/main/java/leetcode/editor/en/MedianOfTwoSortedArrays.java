package leetcode.editor.en;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int [] nums1 = {7,9,10,13, 15, 16, 19, 22, 23, 26, 32};
        int [] nums2 = {0, 3, 5, 6, 8, 11,12, 18, 19, 26,29};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("result = " + result);
    }

/**********************************Median of Two Sorted Arrays**********************************/
//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1;

        while (left < right) {
            //第一个数组的切割点
            int m1 = left + (right - left) / 2;
            //第二个数组的切割点
            int m2 = k - m1;
            //第一个数组的中位数 小于 第二个数组的中位数，说明left肯定不在m1的前面
            if (nums1[m1] < nums2[m2 - 1]) {
                left = m1 + 1;
            } else {
                //第一个数组的中位数 大于 第二个数组的中位数，说明right肯定在m1的左边
                right = m1;
            }
        }

        int m1 = left;
        int m2 = k - left;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        //若合并后的数组长度为奇数
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.en;

/**
 * @Author yida
 * @Date 2022-02-21 16:06
 * @Description 删除已排序数组中的重复元素，并返回不重复元素的个数k,数组的前k个元素就是去重后的非重复元素
 * @return null
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = solution.removeDuplicates(nums);
        System.out.println(k);
    }

/**********************************Remove Duplicates from Sorted Array**********************************/
//Given an integer array nums sorted in non-decreasing order, remove the duplica
//tes in-place such that each unique element appears only once. The relative order
// of the elements should be kept the same. 
//
// Since it is impossible to change the length of the array in some languages, y
//ou must instead have the result be placed in the first part of the array nums. M
//ore formally, if there are k elements after removing the duplicates, then the fi
//rst k elements of nums should hold the final result. It does not matter what you
// leave beyond the first k elements. 
//
// Return k after placing the final result in the first k slots of nums. 
//
// Do not allocate extra space for another array. You must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of
// nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements o
//f nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -100 <= nums[i] <= 100 
// nums is sorted in non-decreasing order. 
// 
// Related Topics Array Two Pointers 
// 👍 5910 👎 9362

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = 0, cur = 0, n = nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur]) {
                ++cur;
            } else {
                nums[++pre] = nums[cur++];
            }
        }
        return nums.length <= 0 ? 0 : (pre + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
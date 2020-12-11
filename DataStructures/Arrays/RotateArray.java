/* 
    Q:  Given an array with random integers.Rotate the array k times in clockwise direction.

    Constraints:
        1 <= nums.length <= 2 * 10^4
        -2^31 <= nums[i] <= 2^31 - 1
        0 <= k <= 10^5

    Source: leetcode

*/

class Solution {
    /*
        Solution-1:
        Author: D-madhukar, RamaKrishnaKunda
        TimeComplexity: O(n)
        Desc: It can be done in 3 reverse operations . 
    */
    public static void rotateArray(int nums[], int k) {
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }  
    public static void reverse(int array[], int start, int end) {
        while(start<end) {
            int t = array[start];
            array[start] =array[end];
            array[end]=t;
            start++;
            end--;
        }
    }
    
}
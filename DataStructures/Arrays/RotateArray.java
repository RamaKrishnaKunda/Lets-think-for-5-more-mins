/* 
    Q: Given an array with random integers.Rotate the array k times in clockwise direction
*/

class Solution {
    /*
        Solution-1:
        Author: D-madhukar
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
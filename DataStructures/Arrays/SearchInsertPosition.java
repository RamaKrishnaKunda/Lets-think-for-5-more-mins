/*
    Q:  Given a sorted array of distinct integers and a target value, return the index if the target is found. 
        If not, return the index where it would be if it were inserted in order.    
    
    Constraints: 
        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums contains distinct values sorted in ascending order.
        -10^4 <= target <= 10^4
    
    Source: leetcode
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(logn)
            Desc: Use binary search for finding the element.If not found, if mid number is greater than target return
            mid else return mid+1
        */
        int l = 0;
        int h = nums.length - 1;
        int mid = l + (h-l)/2;
        while(l<=h){
            mid = l + (h-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                h = mid-1;
            else
                l = mid+1;
        }
        if(nums[mid] > target)
            return mid;
        else
            return mid+1;
    }
}
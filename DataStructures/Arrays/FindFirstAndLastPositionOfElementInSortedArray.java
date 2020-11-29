/*
	Q:  Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
		If target is not found in the array, return [-1, -1].
    
    Constraints: 
        0 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
        nums is a non-decreasing array.
        -109 <= target <= 109
    
    Source: leetcode
*/

class Solution{

	public int[] searchRange1(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Iterate through the array, and check if current element matches target, also check if first index
            is obtained or not. If not obtained store it, else store it to secont index.
        */
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target && idx1 == -1){
                idx1 = i;
            }
            if(idx1 != -1 && nums[i] == target){
                idx2 = i;
            }
        }
        return new int[]{idx1, idx2};
	}

	public int[] searchRange2(int[] nums, int target){
		/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(logn)
            Desc: Using binary search find the left most element. Do another binary search from left most element
            to nums.length - 1 to get the right most element.
        */
        int idx1 = -1;
        int idx2 = -1;
        int l = 0;
        int h = nums.length - 1;
        int mid = l + (h-l)/2;
        while(l<=h){
            mid = l + (h-l)/2;
            if(nums[mid] == target){
                idx1 = mid;
            }
            if(nums[mid] >= target)
                h = mid-1;
            else if(nums[mid] < target)
                l = mid+1;
        }
        if(idx1 == -1)
            return new int[]{idx1, idx2};
        
        l = idx1;
        h = nums.length - 1;
        while(l<=h){
            mid = l + (h-l)/2;
            if(nums[mid] == target){
                idx2 = mid;
            }
            if(nums[mid] > target)
                h = mid-1;
            else if(nums[mid] <= target)
                l = mid+1;
        }
        return new int[]{idx1, idx2};


	}
}
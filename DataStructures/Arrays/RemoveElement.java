/*
	Q:  Given an array nums and a value val, remove all instances of that value in-place and return the new length.
		Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
		The order of elements can be changed. It doesn't matter what you leave beyond the new length.Given a sorted array nums, remove the duplicates in-place such that each element appears only once and 
		returns the new length.
		Do not allocate extra space for another array, you must do this by modifying the input array in-place with
		O(1) extra memory.
    
    Constraints: 
        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100
    
    Source: leetcode
*/

class Solution {
    public int removeElement(int[] nums, int val) {
    	/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Use two pointers, "counter" to iterate over the list, another "tracker" to repleace numbers everytime
            with counter pointing value, except when counter pointing value is val.
        */
        int tracker = 0;
        int counter = 0;
        for(counter = 0; counter < nums.length; counter++){
            if(nums[counter] == val)
                continue;
            else{
                nums[tracker] = nums[counter];
                tracker++;
            }
        }
        return tracker;
    }
}
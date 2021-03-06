/*
	Q:  Given a sorted array nums, remove the duplicates in-place such that each element appears only once and 
		returns the new length.
		Do not allocate extra space for another array, you must do this by modifying the input array in-place with
		O(1) extra memory.
    
    Constraints: 
        0 <= nums.length <= 3 * 10^4
        -10^4 <= nums[i] <= 10^4
        nums is sorted in ascending order.
    
    Source: leetcode
*/

class Solution {
    public int removeDuplicates(int[] nums) {
    	/*
            Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(n)
            Desc: Use two pointers, "counter" to iterate over the list, another "tracker" to repleace numbers when 
            	  there is a change.
        */
        int counter = 0;
        int tracker = 0;
        for(counter = 0; counter < nums.length; counter++){
            if(nums[counter] != nums[tracker]){
                tracker++;
                nums[tracker] = nums[counter];
            }
        }
        return tracker + 1;
    }
}
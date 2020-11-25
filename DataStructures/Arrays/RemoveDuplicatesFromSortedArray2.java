/*
	Q:  Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice 
		and return the new length.
		Do not allocate extra space for another array, you must do this by modifying the input array in-place with
		O(1) extra memory.
    
    Constraints: 
        0 <= nums.length <= 3 * 10^4
        -10^4 <= nums[i] <= 10^4
        nums is sorted in ascending order.
    
    Source: leetcode
*/

class Solution {
	/*
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(n)
		Desc: Maintain two pointers, tracker and counter. Counter to iterate and tracker to update. Update tracker
			  with counter value every time when tracker and counter pointing values are not equal and limit < 2.
	*/
    public int removeDuplicates(int[] nums) {
        int counter = 0;
        int tracker = 0;
        int limit = 1;
        for(counter = 1; counter < nums.length; counter++){
            if(nums[counter] != nums[tracker]){
                tracker++;
                nums[tracker] = nums[counter];
                limit = 1;
                continue;
            }
            if(limit < 2){
                tracker++;
                nums[tracker] = nums[counter];
                limit++;
            }
        }
        return tracker+1;
    }
}
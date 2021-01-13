/*
	Q: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
	   Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

	Constraints:
		n == nums.length
		1 <= n <= 10^4
		0 <= nums[i] <= n
		All the numbers of nums are unique.

	Source: leetcode
*/

class Solution {
	/*
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(n)
		Desc: Compute (n * (n+1)/2). Do sum of all the numbers in the array. Return the difference between them.
	*/
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        boolean nPresent = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums.length)
                nPresent = true;
            sum += nums[i];
        }
        if(!nPresent)
            return n;
        else
            return ((n * (n+1))/2) - sum;
    }
}
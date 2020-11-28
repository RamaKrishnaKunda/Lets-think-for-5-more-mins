/*
    Q:  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
        The replacement must be in place and use only constant extra memory.
    
    Constraints: 
        1 <= nums.length <= 100
        0 <= nums[i] <= 100

    Source: leetcode
 */

class Solution {
    public void nextPermutation(int[] nums) {
        /*
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(n^2)
            Desc: Start from end,  find index where we can swap elements to get next permutation 
         */
        int n= nums.length;
        boolean isNumsSorted = true;
        for(int i=n-2;i>=0;i--){
            int upperBoundIndex= -1;
            for(int j=i+1;j<n;j++){
                if(nums[j] > nums[i]) {
                    if(upperBoundIndex !=-1)
                        upperBoundIndex = nums[upperBoundIndex] > nums[j]? j: upperBoundIndex; 
                    else
                        upperBoundIndex = j;
                } 
            }
            if(upperBoundIndex == -1 )
                continue;
            else{
                //swap
                int tmp = nums[i];
                nums[i] = nums[upperBoundIndex];
                nums[upperBoundIndex] = tmp;
                Arrays.sort(nums, i+1, n);
                isNumsSorted = false;
                break;
            } 
        }
        if(isNumsSorted)
            Arrays.sort(nums);
            
    }
}

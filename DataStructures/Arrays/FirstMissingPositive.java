/*
    Q:  Given an unsorted integer array nums, find the smallest missing positive integer.
        Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
    Constraints: 
        0 <= nums.length <= 300
        -231 <= nums[i] <= 231 - 1
*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar, RamakrishnaKunda
        TimeComplexity: O(n)
        Desc: Solution steps
            first make all negative integers to zero as we dont need them
            make nums[nums[i]-1] =-1 for each (nums[i]>0 && nums[i]<=nums.length)
            Iterate array to find any missing integer(nums[i]!=0) , if exist then return i+1
            else missing number would be nums.length+1 


    */
    public int firstMissingPositive(int[] nums) {
        if(nums.length <1)
            return 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0){
                nums[i]=0;
            }
        }
        int i=0;
        int t=nums[0]-1;
        while(i<nums.length) {
            if(t<0 || t>=nums.length){
                i++;
                t=i>=nums.length?-1:nums[i]-1;
            }
            if(t<nums.length && t>=0) {
                int temp=t;    
                t=nums[temp]-1;
                nums[temp]=-1;
            }
        }
        int result=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=-1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}
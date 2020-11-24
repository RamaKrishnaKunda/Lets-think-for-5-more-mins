/*
    Q:  Given an array nums of n integers and an integer target, 
        find three integers in nums such that the sum is closest to target. 
        Return the sum of the three integers. You may assume that each input would have exactly one solution.
    
    Constraints: 
        3 <= nums.length <= 10^3
        -10^3 <= nums[i] <= 10^3
        -10^4 <= target <= 10^4
    
    Source: leetcode
*/


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /*
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(n^2)
            Desc: same as 3Sum just check the absolute differences to get the closest number
        */
        int n=nums.length;
        Arrays.sort(nums);
        Integer closest = null;;
        for(int i=0;i<n-2;i++) {
            int p1=i+1;
            int p2 = n-1;
            while(p1<p2){
                int sum = nums[p1]+nums[p2] + nums[i];
                if(closest==null) {
                    closest = sum;
                } else {
                    closest = Math.abs(target - sum) < Math.abs(target-closest)? sum: closest; 
                }
                if(sum > target) 
                    p2--;
                else if(sum < target)
                    p1++;
                else 
                    break;
            }
        }
        return closest;
    }
}
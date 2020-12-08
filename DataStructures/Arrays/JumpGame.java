/*
    Q:  Given an array of non-negative integers, you are initially positioned at the first index of the array.
        Each element in the array represents your maximum jump length at that position.
        Determine if you are able to reach the last index.

    Constraints: 
        1 <= nums.length <= 3 * 10^4
        0 <= nums[i][j] <= 10^5

*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: O(n)
        Desc: Maintain pj where pj[i] represents a jump is possible to reach last index. Start from end to beginning
    */
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        int n= nums.length;
        boolean pj[]=new boolean[n];
        pj[n-1]=true;
        for(int i=n-2;i>=0;i--) {
            int sum=Math.min(nums[i],n-i-1);
            int temp=1;
            while(temp<=sum) {
                if(pj[i+temp]==true){
                    pj[i]=true;
                    break;
                }
                temp++;
            }                
        }
        return pj[0];
    }
}
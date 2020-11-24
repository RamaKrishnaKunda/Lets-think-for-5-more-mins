/*
    Q:  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
    
    Constraints:
        2 <= nums.length <= 103
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.

    Source: leetcode
 */



/* 
    Solution-1
    Author: D-madhukar
    TimeComplexity: O(nlogn)
    Desc: maintain index-value as a pair(to maintain index when we sort the array) and sort value wise, then use 2 pointers technique to find indices

*/ 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        class Pair implements Comparable<Pair>{
            int index;
            int value;
            Pair(int index, int value) {
                this.index = index;
                this.value= value;
            }
            public int compareTo(Pair p) {
                if(this.value< p.value)
                    return -1;
                else if(this.value > p.value)
                    return 1;
                else 
                    return 0;
            }
            
        }
        Pair[] pairs = new Pair[nums.length];
        for(int i=0;i<nums.length;i++) 
            pairs[i]= new Pair(i, nums[i]);
        Arrays.sort(pairs);
        int p1=0, p2=nums.length-1;
        int sum =0;
        while(p1<p2){
            if(pairs[p1].value+pairs[p2].value==target) {
                break;
            } else if(pairs[p1].value+pairs[p2].value > target) {
                p2--;
            } else {
                p1++;
            }
        }
        int[] res = new int[2];
        res[0]=pairs[p1].index;
        res[1]=pairs[p2].index;
        return res;
    }
}
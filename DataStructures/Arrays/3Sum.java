/* 
    Q: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    
    Constraints: 
        0 <= nums.length <= 3000
        -105 <= nums[i] <= 
    
    Source: leetcode
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* 
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(n^2)
            Desc: fix one pointer, which becomes 2Sum problem 
        */
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 3)
            return result;
        Set<ArrayList<Integer>> set2 = new HashSet<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            int reqSum = 0-nums[i];
            int p1=i+1;
            int p2=n-1;
            while(p1<p2) {
                if(nums[p1]+nums[p2]==reqSum){
                    ArrayList<Integer> triplet = new ArrayList<>();
                            triplet.add(nums[i]);
                             triplet.add(nums[p1]);
                             triplet.add(nums[p2]);
                             Collections.sort(triplet);
                             if(!set2.contains(triplet)) {
                                 result.add(triplet);   
                                 set2.add(triplet);
                             } 
                    p1++;p2--;
                } else if(nums[p1]+nums[p2] < reqSum) {
                    p1++;
                }
                else{ 
                    p2--;
                }
            }
        }
        return result;
    }
}
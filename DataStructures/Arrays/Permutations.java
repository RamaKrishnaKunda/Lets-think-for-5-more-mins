/*
    Q: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
    
    Constraints: 
        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].

    Source: leetcode
*/
class Solution {
    /*
        Solution-1
        Author: RamaKrishnaKunda
        TimeComplexity: O(n!)
        Desc: Use DFS algorithm.
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, new ArrayList<>());
        return result;
    }
    
    public void permute(List<List<Integer>> result, int[] nums, List<Integer> combination){
        if(combination.size() == nums.length){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(combination.contains(nums[i]))
                continue;
            combination.add(nums[i]);
            permute(result, nums, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
/*
    Q:  Given a collection of candidate numbers (candidates) and a target number (target), 
    	find all unique combinations in candidates where the candidate numbers sum to target.
		Each number in candidates may only be used once in the combination.
		Note: The solution set must not contain duplicate combinations.
    
    Constraints: 
        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30

    Source: leetcode
*/

class Solution {
	/*
		Solution-2
		Author: RamaKrishnaKunda
		TimeComplexity: O(sum of n fibonaci numbers) 
		Desc: Sort the candidates array. Apply DFS. For more info refer youtube.com/watch?v=j9_qWJClp64
	*/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> combination = new ArrayList<>();
        
        findCombinationsToTarget(result, combination, candidates, target, 0);
        return new ArrayList<>(result);
    }
    private void findCombinationsToTarget(Set<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int startIndex){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(i != startIndex && candidates[i - 1] == candidates[i])
                continue;
            if(target < candidates[i])
                break;
            combination.add(candidates[i]);
            findCombinationsToTarget(result, combination, candidates, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
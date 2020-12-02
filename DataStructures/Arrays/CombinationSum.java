/*
    Q:  Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
        It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.\
    Constraints: 
        1 <= candidates.length <= 30
        1 <= candidates[i] <= 200
        All elements of candidates are distinct.
        1 <= target <= 500
*/

class Solution {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        /*
			Solution-1
			Author: D-madhukar
			TimeComplexity: O(sum of n fibonaci numbers) 
			Desc: Sort the candidates array. Find combinations for 1,2,3, 4....till target
			example: {1,2,3,4}
			    1=> {1}
			    2=>{2},{1,1}
			    3=> {3}, {2,1},{1,1,1}
			    .....etc
        */
        Map<Integer, List<List<Integer>>> combinations= new HashMap<>();
        Arrays.sort(candidates);
        for(int numSum=candidates[0];numSum<=target;numSum++){
            combinations.put(numSum, getCombinations(combinations,candidates,numSum));
        }
        List<List<Integer>> result = combinations.containsKey(target)?combinations.get(target):new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        for(int i=0;i<result.size();i++) {
            List<Integer> tmp = result.get(i);
            Collections.sort(tmp);
            if(tmp.size()!=0)
                resultSet.add(tmp);
        }
        return new ArrayList<>(resultSet);
    }
    public List<List<Integer>> getCombinations(Map<Integer, List<List<Integer>>> combinations, int[] candidates,int target) {
        List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<candidates.length;i++) {
                if(candidates[i] >  target)
                    break;
                if(candidates[i]==target) {
                    List<Integer> subSet = new ArrayList<>();
                    subSet.add(target);
                    list.add(subSet);
                }
                else{
                    int subSum = target-candidates[i];
                    List<List<Integer>> tmp = combinations.containsKey(subSum)?combinations.get(subSum): new ArrayList<>();
                    for(int j=0;j<tmp.size();j++) {
                        ArrayList<Integer> tmp1 = (ArrayList<Integer>)tmp.get(j);
                        if(tmp1.size()!=0){
                            tmp1=(ArrayList<Integer>)tmp1.clone();
                            tmp1.add(candidates[i]);
                            list.add(tmp1);  
                        }
                    }
                }
            }
        
        return list;    
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target){
    	/*
    		Solution-2
			Author: RamaKrishnaKunda
			TimeComplexity: O(sum of n fibonaci numbers) 
			Desc: Sort the candidates array. Apply DFS. For more info refer https://youtu.be/irFtGMLbf-s
        */
    	Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombinationToTarget(result, combination, nums, target, 0);
        return result;
    }

    void findCombinationToTarget(List<List<Integer>> result, List<Integer> combination, 
                                int[] nums, int target, int startIndex){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = startIndex; i < nums.length; i++){
            if(nums[i] > target)
                break;
            combination.add(nums[i]);
            findCombinationToTarget(result, combination, nums, target - nums[i], i);
            combination.remove(combination.size() - 1);
        }
    }

}
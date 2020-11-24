import java.util.*;
class Solution {
    /*
        Author: D-madhukar
        Desc: Finding all subsets 
    */
    public List<List<Integer>> subSets(int nums[]) {
        int n =nums.length;
        int numOfSubSets = 1<<n;
        List<List<Integer>> subSets =new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<=numOfSets;i++){
            List<Integer> subSet = new ArrayList<>();
            for(int j=0;j<n;j++ ) {
                if((i>>j)&1)
                    subSet.add(input[j]); 
            }
            Collections.sort(subSet);
            subSets.add(subSet);
        }
        System.out.println(subSets);
    }
}
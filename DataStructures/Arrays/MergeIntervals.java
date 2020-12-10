/*
    Q:  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
        and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Constraints: 
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4

    Source: leetcode
*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar, RamaKrishnaKunda
        TimeComplexity: O(nlogn)
        Desc: Sort intervals by startTime. two intervals can be merged if endtime of prev interval is greater than equal to starttime of current interval
    */
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];            
            } 
        });
        List<List<Integer>> li = new ArrayList<>();
        int prevFirst=intervals[0][0];
        int prevLast= intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevLast>=intervals[i][0]){
                prevLast=Math.max(intervals[i][1],prevLast);             
            } else{
                List<Integer> subLi = new ArrayList<>();
                subLi.add(prevFirst);
                subLi.add(prevLast);
                li.add(subLi);
                prevFirst=intervals[i][0];
                prevLast= intervals[i][1];
            }
        }
        List<Integer> subLi = new ArrayList<>();
        subLi.add(prevFirst);
        subLi.add(prevLast);
        li.add(subLi);
        int result[][]=new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            result[i][0]=li.get(i).get(0);                        
            result[i][1]=li.get(i).get(1);
        }
        return result;
    }
}
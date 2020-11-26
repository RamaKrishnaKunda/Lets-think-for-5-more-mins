/*
	Q:  Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
		(i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai)
		and (i, 0). Find two lines, which, together with the x-axis forms a container, such that
		the container contains the most water
	
	Constraints:
		n = height.length
		2 <= n <= 3 * 10^4	
		0 <= height[i] <= 3 * 10^4
	
	Source: leetcode
*/

class Solution {
	public int maxArea(int[] height) {
		/*
			Solution-1
			Author: D-madhukar, RamaKrishnaKunda
			TimeComplexity: O(n)
			Desc: Maintain 2 pointers high and low. Inorder to maximize the area, move pointer which is
				  pointing to low value.
		*/
        int p1=0;
        int p2=height.length-1;
        int maxResult=0;
        while(p1<p2) {
            int min = Math.min(height[p1], height[p2]);
            maxResult = Math.max(maxResult, min*(p2-p1));
            if(height[p1] < height[p2])
                p1++;
            else 
                p2--;
        }
        return maxResult;
    }
}
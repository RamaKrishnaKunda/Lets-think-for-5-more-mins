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
			Author: RamaKrishnaKunda
			TimeComplexity: O(n)
			Desc: Maintain 2 pointers high and low. Inorder to maximize the area, move pointer which is
				  pointing to low value.
		*/
        int maxStore = 0;
        int low = 0;
        int high = height.length - 1;
        while(low != high){
            if((Math.abs(high - low) * (height[low] < height[high] ? height[low] : height[high])) > maxStore){
                maxStore = Math.abs(high - low) * (height[low] < height[high] ? height[low] : height[high]);
            }
            if(height[low] <= height[high])
                low++;
            else
                high--;
        }
        return maxStore;
    }
}
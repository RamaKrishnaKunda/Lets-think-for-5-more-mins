/*
	Q: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate 
	   the number of 1's in their binary representation and return them as an array.

	Source: leetcode
*/
class Solution {
    public int[] countBits(int num) {
    	/*
			Solution-1
			Author: RamaKrishnaKunda
			TimeComplexity: O(n * sizeof(integer))
			Desc: Performing n & n-1 will remove a single '1' bit. Doing it for all numbers will give the answer.
		*/
        int[] bits1 = new int[num+1];
        for(int i = 1; i < num+1; i++){
            int count = 0;
            int n = i;
            while(n != 0){
                n = n & n-1;
                count++;
            }
            bits1[i] = count;
        }
        return bits1;
    }
}
/*
	Q: Given an integer n, return true if it is a power of two. Otherwise, return false.
	   An integer n is a power of two, if there exists an integer x such that n == 2^x.

	Constraints:
	-2^31 <= n <= 2^31 - 1

	Source: leetcode
*/
class Solution {
	/*
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(1)
		Desc: If bit-wise AND operation of n and n-1 results to 0, then it is power of 2.
	*/
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE)
            return false;
        if((n & (n-1)) == 0)
            return true;
        return false;
    }
}
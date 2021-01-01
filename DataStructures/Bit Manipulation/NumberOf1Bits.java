/*
	Q: Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

	Constraints:
	The input must be a binary string of length 32

	Source: leetcode
*/
public class Solution {
    public int hammingWeight(int n) {
    	/*
    		Solution-1
    		Author: RamaKrishnaKunda
    		TimeComplexity: O(No.of 1 bits)
    		Desc: From n rightmost bit of 1 and remaining right bits have to be reversed to get n-1. So doing
    		a '&'' between n, n-1 will reduce one '1' bit. Do this until the number is 0.
    	*/
        int count = 0;
        while(n != 0){
            n = n & n-1;
            count++;
        }
        return count;
    }
}
/*
	Python Solution
	Solution-2
	Author: RamaKrishnKunda
	TimeComplexity: O(Number of bits)
	Desc: Perform n & 1. If result is 1, then increment count. Perform a rightshift.

	class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0;
        while(n != 0 and n != -2147483648):
            if((n & 1) == 1):
                count+=1
            n = n>>1;
        return count
*/
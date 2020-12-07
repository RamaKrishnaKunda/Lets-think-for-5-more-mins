/*
	Q:  Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
		The digits are stored such that the most significant digit is at the head of the list, and each element
		in the array contains a single digit.
		You may assume the integer does not contain any leading zero, except the number 0 itself.
    
    Constraints:
        1 <= digits.length <= 100
        0 <= digits[i] <= 9
    
    Source: leetcode
*/

class Solution {
    public int[] plusOne(int[] digits) {
    	/*
			Solution-1
        	Author: RamaKrishnaKunda
        	TimeComplexity: O(n)
        	Desc: Add 1 to the last element. If there is any carry, add it up until the first element is reached,
        		  if still there construct new array by keeping the carry at 0 index while copying the rest of the
        		  modified array. 
    	*/
        int sum = 0;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if(i == digits.length - 1)
                sum  = digits[i] + carry + 1;
            else
                sum  = digits[i] + carry;
            carry = 0;
            if(sum >= 10){
                digits[i] = sum % 10;
                carry = sum / 10;
            }
            else
                digits[i] = sum;
            if(carry == 0)
                break;
        }
        if(carry > 0){
            int[] result = new int[digits.length+1];
            result[0] = carry;
            for(int i = 1; i <= digits.length; i++){
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
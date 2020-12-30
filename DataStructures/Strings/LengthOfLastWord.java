/*
	Q: Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
	   A word is a maximal substring consisting of non-space characters only.

	Constraints:
	1 <= s.length <= 10^4
	s consists of only English letters and spaces ' '.

	Source: leetcode
*/
class Solution {
	/*
		Solution-1
		Author: RamaKrishnaKunda
		TimeComplexity: O(n)
		Desc: Trim the spaces. Iterate from the end and count until we reach space.
	*/
    public int lengthOfLastWord(String s) {
        int result = 0;
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ')
                break;
            result++;
        }
        return result;
    }
}
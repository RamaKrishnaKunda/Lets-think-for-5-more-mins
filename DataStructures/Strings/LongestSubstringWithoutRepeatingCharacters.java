/*
    Q: Given a string s, find the length of the longest substring without repeating characters.
    Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: O(s.length)
        Desc: sliding window approach
    */
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
        int result=0, p1=0,p2=0, n=s.length();
        while(p1<n && p2<n) {
            char c = s.charAt(p2);
            if(set.contains(c)){
                set.remove(s.charAt(p1));
                p1++;
            }else{
                set.add(c);
                result =Math.max(result, p2-p1+1);
                p2++;
            }
        }
        return result;
    }
}
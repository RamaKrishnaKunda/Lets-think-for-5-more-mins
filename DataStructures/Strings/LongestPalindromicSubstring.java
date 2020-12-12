/*
    Q: Given a string s, return the longest palindromic substring in s.
    Constraints: 
        1 <= s.length <= 1000
        s consist of only digits and English letters (lower-case and/or upper-case),
*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: O(n^2)
        Desc: find even and odd palindromes seperately.
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        char s1[]= s.toCharArray();
        int longest=1, start=0, end=0;
        if(n==1)
            return s;
        // for even
        for(int i=0;i<n;i++){
            int p1=i,p2=i+1;
            while(p1>-1 && p2<n && s.charAt(p1)==s.charAt(p2)){
               if(longest< p2-p1+1){
                   start=p1;end=p2;
                   longest = p2-p1+1;
               }
                p1--;p2++;
            }
        }
        // for odd
        for(int i=0;i<n;i++){
            int p1=i-1,p2=i+1;
            while(p1>-1 && p2<n && s.charAt(p1)==s.charAt(p2)){
               if(longest< p2-p1+1){
                   start=p1;end=p2;
                   longest = p2-p1+1;
               }
                p1--;p2++;
            }
        }
        return s.substring(start, end+1);
    }
}
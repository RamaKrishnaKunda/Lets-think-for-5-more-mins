/*
    Q: Given a string s, return the longest palindromic substring in s.

    Constraints: 
        1 <= s.length <= 1000
        s consist of only digits and English letters (lower-case and/or upper-case),

    Source: leetcode
*/

class Solution {
    public String longestPalindrome1(String s) {
    	/*
		    Solution-1
		    Author: D-madhukar
		    TimeComplexity: O(n^2)
		    Desc: find even and odd palindromes seperately.
    	*/
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

    public String longestPalindrome2(String s) {
    	/*
    		Solution-2
		    Author: RamaKrishnaKunda
		    TimeComplexity: O(n^3)
		    Desc: Take two pointers one from start and end. Each time check the subString from start and end
		    	  is a palindrome or not. Break the loops when necessary.
    	*/
        if(s.length() == 1)
            return s;
        String palString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.length() - (i+1) < palString.length())
                    break;
            for(int j = s.length(); j > i; j--){
                if(i+j+1 < palString.length())
                    break;
                String sub = s.substring(i, j);
                boolean isPal = isPalindrome(sub);
                if(isPal){
                    if(palString.length() < sub.length()){
                        palString = sub;
                    }
                }
            }
        }
        return palString;
    }
    private boolean isPalindrome(String value){
        int i = 0;
        int j = value.length()-1;
        while(i < j){
            if(value.charAt(i) != value.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
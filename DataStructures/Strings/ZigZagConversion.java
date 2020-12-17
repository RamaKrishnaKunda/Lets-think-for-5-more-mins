/*
    Q: 
        The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R

        And then read line by line: "PAHNAPLSIIGYIR"
        Write the code that will take a string and make this conversion given a number of rows:
        string convert(string s, int numRows);

    Constraints: 
        1 <= s.length <= 1000
        s consists of English letters (lower-case and upper-case), ',' and '.'.
        1 <= numRows <= 1000
*/
class Solution {
    /*
        Solution-1
        Author: D-madhukar
        TimeComplexity: O(s.length)
        Desc: Use 2d array of size (s.length)*(s.length)
    */
    public String convert(String s, int numRows) {
        int n=s.length();
        if(n==1 || numRows==1)
            return s;
        char cArray[][]= new char[numRows][n];
        char result[]=new char[n];
        int i=0,j=0, flag=1,count=0;
        while(count<n) {
            cArray[i][j]=s.charAt(count);
            if(flag==1){
                i++;
                if(i>=numRows){
                    flag=2;
                    i--;
                }
            }
            if(flag==2){
                i--;j++;
                if(i<0){
                    flag=1;
                    i+=2;
                }
            }
            count++;
        }
        count=0;
        for(int l=0;l<numRows;l++) {
            for(int k=0;k<=j;k++){
                int t =(int)cArray[l][k];
                if(t!=0)
                    result[count++]=(char)t;
            }
        }
        return new String(result);
    }
}
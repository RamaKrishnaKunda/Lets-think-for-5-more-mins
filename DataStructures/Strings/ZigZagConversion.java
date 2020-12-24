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

    Source: leetcode
*/
class Solution {
    public String convert1(String s, int numRows) {
        /*
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(s.length)
            Desc: Use 2d array of size (s.length)*(s.length)
        */
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
    public String convert(String s, int numRows) {
        /*
            Solution-1
            Author: D-madhukar
            TimeComplexity: O(n)
            Desc: Start whih 1 and loop upto numRows. The difference between indicies form a pattern. The pattern
            for numRows = 6(even) looks like 2n-2, (2n-4, 2), (2n-6, 4), (2n-6, 4), (2n-4, 2), 2n-2. The pattern
            for numRows = 5(odd) looks like 2n-2, (2n-2, 2), 2n-6, (2, 2n-2), 2n-2.
        */
        if(s.length() <= numRows || numRows == 1)
            return s;
        
        List<Integer> difference = new ArrayList<>();
        String result = "";
        int base = 2;
        for(int i = 0; i < numRows; i++){
            if(i >= numRows / 2){
                if(numRows % 2 == 0)
                    base -= 2;
                difference.add(base);
                if(numRows % 2 != 0)
                    base -= 2;
                continue;
            }
            difference.add(base);
            base += 2;
        }
        List<Integer> subDifference = new ArrayList<>();
        int subDiff = 0;
        for(int i = 0; i < numRows / 2; i++){
            subDifference.add(subDiff);
            subDiff += 2;
        }
        if(numRows%2 != 0){
            int index = numRows / 2;
            subDifference.add(index, 0);
        }
        for(int i = numRows / 2; i < numRows; i++){
            subDifference.add(i, -subDifference.get(numRows - i - 1));
        }
        for(int i = 1; i <= numRows; i++){
            int index = i;
            subDiff = subDifference.get(i - 1);
            boolean jump = true;
            if(subDiff < 0)
                jump = false;
            int diff = (2*numRows) - difference.get(i - 1);
            while(index <= s.length()){
                if(subDiff == 0){
                    result += s.charAt(index - 1);
                    index += diff;
                }
                if(subDiff > 0){
                    result += s.charAt(index - 1);
                    if(jump == true){
                        index += diff;
                        jump = false;
                    }
                    else{
                        index += subDiff;
                        jump = true;
                    }
                }
                if(subDiff < 0){
                    result += s.charAt(index - 1);
                    if(jump == true){
                        index += diff;
                        jump = false;
                    }
                    else{
                        index -= subDiff;
                        jump = true;
                    }
                }
            }
        }
        return result;
    }
}
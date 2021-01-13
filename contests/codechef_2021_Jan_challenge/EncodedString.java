/*
    Q:
        An encoder encodes the first 16 lowercase English letters using 4 bits each. The first bit (from the left) of the code is 0 if the letter lies among the first 8 letters, else it is 1, signifying that it lies among the last 8 letters. The second bit of the code is 0 if the letter lies among the first 4 letters of those 8 letters found in the previous step, else it's 1, signifying that it lies among the last 4 letters of those 8 letters. Similarly, the third and the fourth bit each signify the half in which the letter lies.
        For example, the letter j would be encoded as :
            Among (a,b,c,d,e,f,g,h | i,j,k,l,m,n,o,p), j appears in the second half. So the first bit of its encoding is 1.
            Now, among (i,j,k,l | m,n,o,p), j appears in the first half. So the second bit of its encoding is 0.
            Now, among (i,j | k,l), j appears in the first half. So the third bit of its encoding is 0.
            Now, among (i | j), j appears in the second half. So the fourth and last bit of its encoding is 1.
            So j's encoding is 1001,
            Given a binary encoded string S, of length at most 105, decode the string. That is, the first 4 bits are the encoding of the first letter of the secret message, the next 4 bits encode the second letter, and so on. It is guaranteed that the string's length is a multiple of 4.
        input:
            The first line of the input contains an integer T, denoting the number of test cases.
            The first line of each test case contains an integer N, the length of the encoded string.
            The second line of each test case contains the encoded string S
        output:
            For each test case, print the decoded string, in a separate line.
        constraints:
            1≤T≤10
            4≤N≤105
            The length of the encoded string is a multiple of 4.
            0≤Si≤1
        source: https://www.codechef.com/JAN21C/problems/DECODEIT
*/
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{   
    /*
        Author: D-madhukar
        TimeComplexity: O(s.length())
        Desc: Use 2 pointer technique

    */
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringBuffer res =new StringBuffer();
        //String s 
            for(int j=0;j<s.length();j=j+4) {
                int p1=1,p2=16,sub=8;
                for(int k=j;k<j+4;k++){
                    int bit = Integer.parseInt(String.valueOf(s.charAt(k)));
                    if(bit==1){
                        p1+=sub;
                    } else{
                        p2-=sub;
                    }
                    sub/=2;
                }
                int v =97+p1-1;
            // use StringBufffer if you have more append operations
                res= res.append((char)v);
            }
            System.out.println(res);
        }
	}
}

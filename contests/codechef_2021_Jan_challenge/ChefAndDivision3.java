/*
    Q: 
    Chef wants to host some Division-3 contests. Chef has N setters who are busy creating new problems for him. The ith setter has made Ai problems where 1≤i≤N.
        A Division-3 contest should have exactly K problems. Chef wants to plan for the next D days using the problems that they have currently. But Chef cannot host more than one Division-3 contest in a day.
        Given these constraints, can you help Chef find the maximum number of Division-3 contests that can be hosted in these D days?

        Input:
            The first line of input contains a single integer T denoting the number of test cases. The description of T test cases follows.
            The first line of each test case contains three space-separated integers - N, K and D respectively.
            The second line of each test case contains N space-separated integers A1,A2,…,AN respectively.
        Output:
            For each test case, print a single line containing one integer ― the maximum number of Division-3 contests Chef can host in these D days.
    Constraints:
        1≤T≤103
        1≤N≤102
        1≤K≤109
        1≤D≤109
        1≤Ai≤107 for each valid i

    Source: https://www.codechef.com/JAN21C/problems/DIVTHREE


*/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   /*
        Author: D-madhukar, RamaKrishnaKunda
        TimeComplexity: O(n)
    */
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0;i<T;i++) {
		    int N, K, D;
		    long sum =0;
		    N = s.nextInt();
		    K= s.nextInt();
		    D = s.nextInt();
		    for(int j=0;j<N;j++) {
		        sum+=s.nextInt();
		    }
		    long result = sum / K;
		    if(result > D)
		        result =D;
		     System.out.println(result);
		}
	}
}



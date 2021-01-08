/*
    Q:
        Elections are coming soon. This year, two candidates passed to the final stage. One candidate is John Jackson and his opponent is Jack Johnson.
        During the elections, everyone can vote for their favourite candidate, but no one can vote for both candidates. Then, packs of votes which went to the same candidate are formed. You know that for John Jackson, there are N packs containing A1,A2,…,AN votes, and for Jack Johnson, there are M packs containing B1,B2,…,BM votes.
        The winner is the candidate that has strictly more votes than the other candidate; if both have the same number of votes, there is no winner. You are a friend of John Jackson and you want to help him win. To do that, you may perform the following operation any number of times (including zero): choose two packs of votes that currently belong to different candidates and swap them, i.e. change the votes in each of these packs so that they would go to the other candidate.
        You are very careful, so you want to perform as few swaps as possible. Find the smallest number of operations you need to perform or determine that it is impossible to make John Jackson win.

        Input
            The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
            The first line of each test case contains two space-separated integers N and M.
            The second line contains N space-separated integers A1,A2,…,AN.
            The third line contains M space-separated integers B1,B2,…,BM.
        Output
            For each test case, print a single line containing one integer ― the smallest number of swaps needed to make John Jackson win, or −1 if it is impossible.
        constraints:
            1≤T≤103
            1≤N,M≤103
            1≤Ai≤106 for each valid i
            1≤Bi≤106 for each valid i
            the sum of N over all test cases does not exceed 104
            the sum of M over all test cases does not exceed 104
        source:https://www.codechef.com/JAN21C/problems/FAIRELCT
*/

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
    /*
        Author: D-madhukar
        TimeComplexity: O(n+m)
        Desc: Sort in a in descending order, b in ascending order then swap elements in both arrays
    */
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
		    String nm[]  = br.readLine().split(" ");
		    int n = Integer.parseInt(nm[0]);
		    int m = Integer.parseInt(nm[1]);
		    Integer a[]= new Integer[n];
		    Integer b[]=new Integer[m];
		    long sum1 = 0;
		    long sum2=0;
		    String input[] = br.readLine().split(" ");
		    for(int j=0;j<input.length;j++){
		        int t = Integer.parseInt(input[j]);
		        a[j]=t;
		        sum1+=t;
		    }
		    input = br.readLine().split(" ");
		    for(int j=0;j<input.length;j++){
		        int t = Integer.parseInt(input[j]);
		        sum2+=t;
		        b[j]=t;
		    }
		    Arrays.sort(a);
		    Arrays.sort(b, Collections.reverseOrder());
		    int noOfSwaps = 0, p1=0,p2=0;
		    while(p1<n && p2<m && sum1<=sum2){
		        if(a[p1]<b[p2]) {
		            sum1+=b[p2]-a[p1];
		            sum2+=a[p1]-b[p2];
		            p1++;p2++;noOfSwaps++;
		        } else 
		            break;
		    }
		    if(sum1>sum2)
		        System.out.println(noOfSwaps);
		    else   
		        System.out.println(-1);
		}
	}
}

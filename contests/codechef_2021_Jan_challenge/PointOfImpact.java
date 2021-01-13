/*
    Q:
        You are playing a Billiards-like game on an N×N table, which has its four corners at the points {(0,0),(0,N),(N,0), and (N,N)}. You start from a coordinate (x,y), (0<x<N,0<y<N) and shoot the ball at an angle 45∘ with the horizontal. On hitting the sides, the ball continues to move with the same velocity and ensuring that the angle of incidence is equal to the angle of reflection with the normal, i.e, it is reflected with zero frictional loss. On hitting either of the four corners, the ball stops there and doesn’t move any further.
        Find the coordinates of the point of collision, when the ball hits the sides for the Kth time. If the ball stops before hitting the sides K times, find the coordinates of the corner point where the ball stopped instead.

    Input:
        The first line of the input contains an integer T, the number of testcases.
        Each testcase contains a single line of input, which has four space separated integers - N, K, x, y, denoting the size of the board, the number of collisions to report the answer for, and the starting coordinates.
    Output:
        For each testcase, print the coordinates of the ball when it hits the sides for the Kth time, or the coordinates of the corner point if it stopped earlier.

    Constraints
        1≤T≤105
        2≤N≤109
        1≤K≤109
    source: https://www.codechef.com/JAN21C/problems/BILLRD
*/
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef0
{
    /*
        Author: D-madhukar
        TimeComplexity: O(1)
        Desc: Just finding formula is enough
    */
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String s[]= br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);
            int store[][] = new int[4][2];
            if(x==y) {
                System.out.println(n + " " + n);
                continue;
            }
            if(x-y<0){
                store[0][0]=0;
                store[0][1]=y-x;
                store[1][0]=n-store[0][1];
                store[1][1]=n;
                
            }else {
                store[0][0] =x-y;
                store[0][1]= 0;
                store[1][0]=n;
                store[1][1]=n-store[0][0];
            }
            store[2][0]=store[1][1];
            store[2][1]=store[1][0];
            
            store[3][0]=store[0][1];
            store[3][1]=store[0][0];
            int noOfRotations = k%4;
            System.out.println(store[noOfRotations][0]+ " "+ store[noOfRotations][1]);
            
        }
	}
}

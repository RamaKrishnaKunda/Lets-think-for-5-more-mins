/*
    Q:  You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    Constraints:
        matrix.length == n
        matrix[i].length == n
        1 <= n <= 20
        -1000 <= matrix[i][j] <= 1000 
*/

class Solution {
    /*
        Solution-1
        Author: D-madhukar, RamaKrishnaKunda
        TimeComplexity: O(n*n)
        Desc: Transpose the matrix then reverse each row 
    */
    public void rotate(int[][] matrix) {
        if(matrix.length==1)
            return;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int t = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i]=t;
            }
        }
        for(int i=0;i<n;i++) {
            int p1=0,p2=n-1;
            while(p1<p2){
                int t = matrix[i][p1];
                matrix[i][p1]=matrix[i][p2];
                matrix[i][p2]=t;
                p1++;p2--;
            }
        }
    }
}
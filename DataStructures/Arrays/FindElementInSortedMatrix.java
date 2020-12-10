/* 
    Q: GIven a matrix n*m , which is rowwise sorted and columnwise sorted. FInd the given element in the matrix
*/
class Solution {
    public static void main(String args[]) {
     int matrix[][]= new int[][]{
         {-5,-3,8,10,15},
         {-1,0,15,20,23},
         {4,5,18,35,44},
         {10,12,23,41,74},
         {27,34,68,79,134}
         
     };
    //  int result[] = findElementInMatrix(matrix,18); 
    //  int result[] = findElementInMatrix(matrix,-18);
        int result[] = findElementInMatrix(matrix,-5);
        System.out.print(result[0]+ " " + result[1]);
     
    }
    /* 
        Solution-1:
        Author: D-madhukar
        TimeComplexity: O(n+m)
        Desc: As matrix is sorted rowwise and columnwise , we can start from top right corner.
        Check if current element greater the target then move backwards in same row otherwise move to next row in same column 
    */
    public static int[] findElementInMatrix(int matrix[][], int target) {
        int rows = matrix.length;
        int columns= matrix[0].length;
        int startI=0, startJ=columns-1;
        while(startI<rows && startJ >=0) {
            if( matrix[startI][startJ]==target)
                return new int[]{startI, startJ};
            if(matrix[startI][startJ]> target){
                startJ--;
            } else{
                startI++;
            }
        }
        return new int[]{-1,-1};
    }
    
}
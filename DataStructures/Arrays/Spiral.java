/*
	Q:  Given an m x n matrix, return all elements of the matrix in spiral order.
    
    Constraints: 
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100
    
    Source: leetcode
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	/*
    		Solution-1
            Author: RamaKrishnaKunda
            TimeComplexity: O(m*n)
            Desc: Loop until all elements are covered. The direction should be EAST->SOUTH->WEST->NORTh. and this
            	  continues until the loop ends. We can use m and n for upper bound, and nLimit and mLimit as lower
            	  bound.
    	*/
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int totalElements = (m+1)*(n+1);
        int nLimit = 0;
        int mLimit = 1;
        List<Integer> result = new ArrayList<>();
        int tracker = 0;
        String direction = "EAST";
        int i = 0;
        int j = 0;
        while(tracker < totalElements){
            result.add(matrix[i][j]);
            if(direction.equals("EAST") && j <= n){
                if(j == n){
                    direction = "SOUTH";
                    i++;
                }
                else
                    j++;   
            }
            else if(direction.equals("SOUTH") && i <= m){
                if(i == m){
                    direction = "WEST";
                    j--;
                }
                else
                    i++;
            }
            else if(direction.equals("WEST") && j >= nLimit){
                if(j == nLimit){
                    direction = "NORTH";
                    i--;
                }
                else
                    j--;
            }
            else if(direction.equals("NORTH") && i >= mLimit){
                if(i == mLimit){
                    direction = "EAST";
                    j++;
                    m--;
                    n--;
                    nLimit++;
                    mLimit++;
                }
                else
                    i--;
            }
            tracker++;
        }
        return result;
    }


    /*
        Solution-2
            Author: D-madhukar
            TimeComplexity: O(m*n)
            Desc: Loop until all elements are covered. use flag variables with(1,2,3,4 values for clockwise) and this
            	  continues until the loop ends. Maintained 4 bounds rowLowerBound, rowUpperBound, columnLowerBound, columnUpperBound
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0)
            return result;
        int xlBound=-1;
        int ylBound= -1;
        int xuBound=matrix.length;
        int yuBound= matrix[0].length;
        int i=0, j=0;
        int flag=1;
        int count=0;
        while(count<(matrix.length*matrix[0].length) ){
            if(flag!=0) {
                result.add(matrix[i][j]);
                count++;
            }
            else 
                flag=1;
            if(flag==1){
                j++;
                if(j>=yuBound){
                    j--;
                    flag++;
                    xlBound++;
                }
            } 
            if(flag==2){
                i++;
                if(i>=xuBound){
                    i--;
                    flag++;
                    yuBound--;
                }
            }
            if(flag==3){
                j--;
                if(j<=ylBound){
                    j++;
                    flag++;
                    xuBound--;
                }
            } 
            if(flag==4){
                i--;
                if(i<=xlBound){
                    i++;
                    flag=0;
                    ylBound++;
                }
            }
        }
        return result;
    }
}

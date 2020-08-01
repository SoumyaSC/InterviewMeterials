package Algorithms;
/*In MATLAB, there is a very useful function called 'reshape',
which can reshape a matrix into a new one with different size but keep its original data.

        You're given a matrix represented by a two-dimensional array,
        and two positive integers r and c representing the row number and
        column number of the wanted reshaped matrix, respectively.

        The reshaped matrix need to be filled with all the elements
        of the original matrix in the same row-traversing order as they were.

        If the 'reshape' operation with given parameters is possible
        and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
*/

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int count = 0;

        //get the no of elements in matrix
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                count++;
            }
        }

        //Debug - Print count
        //System.out.println("Count of ints in matrix: " + count);

        int [][]resultMatrix = new int[r][c];

        //construct a 1D matrix for moving data from input matrix to tmp matrix 1D
        int []tmp = new int[count];

        //Move nums array into tmp matrix
        //Copy 2D array to 1D array
        int k = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                tmp[k++] = nums[i][j];
            }
        }

        //Debug - Print tmp array
        /*System.out.print("Printing the tmp array");
        for(int i=0; i<tmp.length; i++){
            System.out.print(" " + tmp[i]);
        }*/

        //Move tmp matrix into final array
        //Copy 1D array to 2D array
        for(int i=0; i<resultMatrix.length; i++){
            for(int j=0; j<resultMatrix[i].length; j++){
                resultMatrix[i][j] = tmp[(j*1) + i];
            }
        }
        return resultMatrix;
    }
}

class DriverMatrixReshape{
    public static void main(String []args){
        int [][]arr = new int[2][2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;


        ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
        int [][]newArr = reshapeMatrix.matrixReshape(arr, 1, 4);

        //Print the output
        for(int i=0; i<newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.println(newArr[i][j]);
            }
        }
    }
}

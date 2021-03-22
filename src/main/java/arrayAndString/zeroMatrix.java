package arrayAndString;

/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.*/

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

public class zeroMatrix {

    public static void main(String[] args){


    }
    //1. Check if the first row and first column have any zeros, and set
    // variables rowHasZero and columnHasZero.
    //2. Iterate through the rest of the matrix, setting matrix[ i] [ 0)
    // and matrix [ 0) [ j] to zero whenever there's a zero in matrix[i] [j ].
    //3. Iterate through rest of matrix, nullifying row i if
    // there's a zero in matrix [ i] [ 0].
    //4. Iterate through rest of matrix, nullifying column j if
    // there's a zero in matrix [ 0] [ j].
    //5. Nullify the first row and first column, if necessary
    // (based on values from Step 1 ).
    public static void setZeros(int[][] matrix){
        boolean rowHasZero = false;
        boolean colHasZero = false;

        //check if first row has a zero
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                rowHasZero = true;
                break;
            }
        }

        //check if first column has a zero
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }
        //check for zeros in the rest of the array
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Nullify rows based on values in first column
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
//                nullifyRow(matrix,i);
            }
        }

        //Nullify columns based on values in first row
        for(int j = 1; j < matrix[0].length;j++){
            if(matrix[0][j] == 0){
//                nullifyColumn(matrix, j);
            }
        }
        //Nullify first row
        if(rowHasZero){
//            nullifyRow(matrix, 0);
        }
        //Nullify first column
        if(colHasZero){
//            nullifyColumn(matrix, 0);
        }
    }

}

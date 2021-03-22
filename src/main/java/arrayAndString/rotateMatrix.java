package arrayAndString;

/*Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?*/

public class rotateMatrix {
    public static void main(String[] args){
        int[][] matrix = new int[2][2];
        if(matrix.length == 0 || matrix[0].length != matrix.length){

        }
    }
    //implement the rotation in layers
    //perform a circular rotation on each layer as moving the top edges to the right edges
    //the right edges to bottom edges, the bottom edges to the left
    //left edge to the top edge
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            int first = i;
            int last = n -1 - i;
            for(int j = first; j < last; j++){
                int offset = j - first;
                int top = matrix[first][j]; //save top
                //left -> top
                matrix[first][j] = matrix[last - offset][first];
                //bottom ->left
                matrix[last-offset][first] = matrix[last][last-offset];
                //right -> bottom
                matrix[last][last-offset] = matrix[j][last];
                //top -> right
                matrix[j][last] = top;
            }
        }
    }
}

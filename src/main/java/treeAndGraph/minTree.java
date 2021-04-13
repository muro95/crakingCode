package treeAndGraph;


//Given a sorted (increasing order) array with unique integer elements, write an
//algorithm to create a binary search tree with minimal height.//

import javax.swing.tree.TreeNode;

public class minTree {

    //To create a minimal height, we need to match the number of nodes in both sides,
    //which means that the root to be the middle of the array

    //#1: First implement is to used a single root.insertNode(int v) method which
    //inserts the value v through a recursive process that starts with the root node.
    //This will indeed construct a tree with minimal height but it will not
    //do so very efficiently. AS Time: O( N log N) to traversing the tree.

    //#2 Second implement by recursively using the createMinimalBSt method.  this method
    //is passed just a subsection of the array and returns the root of mnimal tree

    //To do:
    //1 Insert into teh tree the middle element of the array
    //2 Insert into the left subtree the left subarray elements
    //3 Insert into the right subtree thr right subarray elements
    //4 Recurse
    public static void main(String[] args){

    }

    public TreeNode createMinimalBST(int [] array){
        return createMinimalBST(array, 0, array.length -1);
    }

    public TreeNode createMinimalBST(int[] array, int start, int end){
        if(end < start){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(arr, start, mid -1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}

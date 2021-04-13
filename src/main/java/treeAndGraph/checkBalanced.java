package treeAndGraph;

/*Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.*/


public class checkBalanced {

    public static void main(String[] args){

    }
    //Sol 1 : We recurse through the entire tree, then compute the heights of each subtree
    //Time: 0(NlogN) as getHeight is called repeatedly on the same nodes.
    int getHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //Sol 2: We check the height of each subtree as we recurse down the root.
    //We get the heights of each node (left and right subtree) through checkHeight
    //If the subtree is balanced, the function will return the actual height of subtree
    //If it is not balanced, then the function will return an error code.
    //Time O(n), Space: 0(H);

    int checkHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight, rightHeight) +1;
        }
    }
    boolean isBalanced(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}

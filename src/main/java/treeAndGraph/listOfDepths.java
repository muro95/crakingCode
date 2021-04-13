package treeAndGraph;

/*Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).*/


import java.util.ArrayList;
import java.util.LinkedList;

public class listOfDepths {

    public static void main(String[] args){
    }
    //First solution using depth-first-search
    public TreeNode {

    }
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> list = null;
        if(lists.size() == level){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    //Sol 2 Using breadth-first search

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>(); //Visit root
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0){
            result.add(current); //Add previous level
            LinkedList<TreeNode> parents = current; //Go to next level
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}

/*
    Q:
        Given the root of a binary tree, determine if it is a valid binary search tree (BST).
        A valid BST is defined as follows:
        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
    
*/
class Solution {
    /*
        Author: D-madhukar
        TimeComplexity: O(n)
        Desc: Use inorder. In inorder traversal every element is greater than previous element
    */
    public boolean isValidBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
      isBST(root, p,l);
      return l.size()==0;
    }
    public void isBST(TreeNode root, List<Integer> prev , List<Integer> res) {
        if(root==null)
            return ;        
        isBST(root.left,prev,res);
        if(prev.size()!=0 && root.val<=prev.get(0)){
            res.add(1);
            return;
        }
        if(prev.size()==0)
            prev.add(root.val);
        else
            prev.add(0,root.val);
        isBST(root.right,prev,res);
    }
}
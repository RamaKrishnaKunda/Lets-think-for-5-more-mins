/*
    Q:
        Given preorder and inorder traversal of a tree, construct the binary tree.
        Note:
        You may assume that duplicates do not exist in the tree.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        Author:D-madhukar
        TimeComplexity: O(<n^2)
        Desc: Recursion approach
    */
    int cur =-1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return build(0, n-1,preorder, inorder);
    }
    public TreeNode build(int i, int j , int[] pre, int[] in) {
        if(cur>=pre.length)
            return null;
        if(i>j)
            return null;
        cur++;
        TreeNode node = new TreeNode(pre[cur]);
        int inIndex=i;
        for(int p=i;p<=j;p++) {
            if(in[p]==pre[cur]){
                inIndex=p;
            }
        }
        node.left = build(i,inIndex-1, pre, in);
        node.right = build(inIndex+1, j, pre, in);
        return node;
    }
    
}
 
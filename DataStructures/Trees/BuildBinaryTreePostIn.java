/*
    Q:
        Given inorder and postorder traversal of a tree, construct the binary tree.
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
    int cur;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        cur=n;
        return build(0, n-1,postorder, inorder);
    }
    public TreeNode build(int i, int j , int[] post, int[] in) {
        if(cur<=0)
            return null;
        if(i>j)
            return null;
        cur--;
        TreeNode node = new TreeNode(post[cur]);
        int inIndex=i;
        for(int p=i;p<=j;p++) {
            if(in[p]==post[cur]){
                inIndex=p;
                break;
            }
        }
        node.right = build(inIndex+1, j, post, in);
        node.left = build(i,inIndex-1, post, in);
        return node;
    }
}
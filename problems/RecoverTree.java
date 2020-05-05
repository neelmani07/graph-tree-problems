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
class Solution
{
    public TreeNode funct(TreeNode root,String S,int k,int j)
    {
        root.val=s.charAt(k);
        if(Character.isDigit(S.charAt(j+2)))
        {
            funct(root.left,S,k+2,j+1);
            funct(root.rigth,S,k+5,j+1);
        }
        return root;
    }
    public TreeNode recoverFromPreorder(String S) 
    {
        TreeNode root=newTreeNode();
        root=funct(root,S,0,0);
        return root;
    }
}

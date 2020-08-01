/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
class SymmetricTree
{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null) != (q != null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
       /* if (p.right.val != q.left.val) {
            return false;*/
        
        return this.isSameTree(p.left, q.right) && this.isSameTree(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root)
    {
        if(root==null)
            return true;
        return isSameTree(root.left,root.right);
        }
}

class KthMininBST
{
    ArrayList<Integer> al=new ArrayList<Integer>();int i=0;
    public int kthSmallest(TreeNode root, int k)
    {
        inorder(root,k);
        return al.get(k-1);
    }
    public List inorder(TreeNode root,int k)
    {
        if(root==null)
        return al;
        inorder(root.left,k);
        al.add(root.val);i++;
        if(i==k)return al;
        inorder(root.right,k);
        return al;
        
    }
}
// a better approach  :-
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
class KthMininBST
{
    //ArrayList<Integer> al=new ArrayList<Integer>();
    int i=0;int a=0;
    public int kthSmallest(TreeNode root, int k)
    {
        
        return inorder(root,k);
    }
    public int inorder(TreeNode root,int k)
    {
        if(root==null)
        return 0;
        inorder(root.left,k);
        i++;
        if(i==k)a=root.val;
        inorder(root.right,k);
        return a;
        
    }
}

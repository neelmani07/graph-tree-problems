/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).
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
class DelNode
{
    public TreeNode deleteNode(TreeNode root, int key) {
	if (root == null) return null;

	if (root.val == key) {
		// find the bottom-left leaf of the immediate right node
		// if it exists
		if (root.right != null) {
			TreeNode curr = root.right;

			while (curr.left != null) {
				curr = curr.left;
			}

			curr.left = root.left;
			return root.right;
		} 
		return root.left;
	}

	root.left = deleteNode(root.left, key);
	root.right = deleteNode(root.right, key);

	return root;
}
}

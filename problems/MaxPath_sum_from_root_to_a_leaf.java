/*		
This question was asked by Apple.

Given a binary tree, find a minimum path sum from root to a leaf.

For example,           1  
		     /   \
		   10     15
		   / \   /  \
		  4  -3 -6   -11
		        / \   / \
                       1  2  -3  4

ans is 2 , since 1, +15, -11, -3 =2
 */

       class Node 
       { 
		int data; 
		Node left, right; 

		Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
       } 

      class MaxPath_sum_from_root_to_a_leaf
      { 
	        Node root;
	  
	        public static int maxSumPath(Node root)
	        {
			if(root.left == null && root.right == null)
			  	return root.data;
		      	else
			  	return (root.data + Math.min(maxSumPath(root.left),maxSumPath(root.right)));
	        }
	        // driver function to test the above functions 
		public static void main(String args[]) 
		{ 
			MaxPath_sum_from_root_to_a_leaf tree = new MaxPath_sum_from_root_to_a_leaf();            
			tree.root = new Node(1); 		       
			tree.root.left = new Node(10); 		
			tree.root.right = new Node(15); 
			tree.root.left.left = new Node(4); 
			tree.root.left.right = new Node(-3); 
	      	        tree.root.right.right = new Node(-11); 
			tree.root.right.left = new Node(-6);
			tree.root.right.left.left = new Node(1);
			tree.root.right.left.right = new Node(2);
			tree.root.right.right.left = new Node(-3);
			tree.root.right.right.right = new Node(4);
			int sum = tree.maxSumPath(tree.root); 
			 
			System.out.println("Sum of nodes is : " + sum); 
		} 
      } 
 


public class AVL_Tree {
	AVL_Tree_Node root;

	// Function to get height of a node
	public int height(AVL_Tree_Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	// Function to get maximum of two nodes height
	public int max(int first_node_height, int second_node_height) {
		return ((first_node_height > second_node_height) ? first_node_height
				: second_node_height);
	}

	// x --> given node
	// y --> left_node_Of x
	// t --> right node of y
	public AVL_Tree_Node rightRotationFor(AVL_Tree_Node x) {
		AVL_Tree_Node y = x.left;
		AVL_Tree_Node t = y.right;

		// rotate
		y.right = x;
		x.left = t;

		// Updating heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// y is the new root
		return y;
	}

	// x --> given node
	// y --> right_node_Of x
	// t --> left node of y
	public AVL_Tree_Node leftRotationFor(AVL_Tree_Node x) {
		AVL_Tree_Node y = x.right;
		AVL_Tree_Node t = y.left;

		// rotate
		y.left = x;
		x.right = t;

		// Updating heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// y is the new root
		return y;
	}

	// returning the balance factor of a given node
	public int getBalance(AVL_Tree_Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);

	}

	public AVL_Tree_Node insert(AVL_Tree_Node node, String key) {

		// BST insertion - start
		if (node == null) {
			return (new AVL_Tree_Node(key));
		}

		if (key.compareTo(node.key) > 0) {
			// Recursion
			node.right = insert(node.right, key);

		} else if (key.compareTo(node.key) < 0) {
			// Recursion
			node.left = insert(node.left, key);

		} else {
			// Duplicate keys not allowed
			return node;
		}
		// BST insertion - end


		// Update the height of inserted node
		node.height = max(height(node.left), height(node.right)) + 1;

		// Check if inserted node is unbalanced
		int balance = getBalance(node);

		// If inserted node becomes unbalanced
		
		if(balance > 1){
			// Check Left Left Case
			if (key.compareTo(node.left.key) < 0) {
				return rightRotationFor(node);
			}
			// Check Left Right Case
			if (key.compareTo(node.left.key) > 0) {
				node.left = leftRotationFor(node.left);
				return rightRotationFor(node);
			}
		}
		else if(balance < -1 ){
			// Check Right Right Case
			if (key.compareTo(node.right.key) > 0) {
				return leftRotationFor(node);
			}
			// Check Right Left Case
			if (key.compareTo(node.right.key) < 0) {
				node.right = rightRotationFor(node.right);
				return leftRotationFor(node);
			}
		}
		
		return node;
		
	}

	
	// print preorder traversal with each node's height
	public void preOrder(AVL_Tree_Node node) {
		if (node != null) {
			System.out.println(node.key +"        "+ node.height);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public AVL_Tree_Node Search(AVL_Tree_Node root_node, String key) {
		if (root_node == null || root_node.key.equals(key)) {
			if(root_node == null){
				System.out.println(key + "is not found");
			}
			else{
				System.out.println(key + " is found at height equals to " + root_node.height);
			}
			return root_node;
		} else {
			if (root_node.key.compareTo(key) > 0) {
				return Search(root_node.left, key);
			} else {
				return Search(root_node.right, key);
			}
		}
	}
}

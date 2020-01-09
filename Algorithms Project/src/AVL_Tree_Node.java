public class AVL_Tree_Node {
	String key;
	
	int height;
	
	AVL_Tree_Node left, right;

	AVL_Tree_Node(String key) {
		
		this.key = key;
		
		this.height = 1;
		
	}
}

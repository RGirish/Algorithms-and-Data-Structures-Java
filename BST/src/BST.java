public class BST {

	Node root;

	BST(int n) {
		root = new Node();
		root.n = n;
		root.left = root.right = null;
	}

	void insert(Node node, int n) {
		if (node.n > n) {
			if (node.left == null) {
				Node newNode = new Node();
				newNode.n = n;
				newNode.left = newNode.right = null;
				node.left = newNode;
			} else {
				insert(node.left, n);
			}
		} else if (node.n < n) {
			if (node.right == null) {
				Node newNode = new Node();
				newNode.n = n;
				newNode.left = newNode.right = null;
				node.right = newNode;
			} else {
				insert(node.right, n);
			}
		}
	}

	void delete(Node node, int n) {
		if (node.n > n) {
			delete(node.left, n);
		} else if (node.n < n) {
			delete(node.right, n);
		} else {
			if (node.left == null && node.right == null) {
				node = null;
			} else if(node.left == null && node.right != null) {
				node = node.right;
			} else if(node.left != null && node.right == null) {
				node = node.left;
			} else {
				
			}
		}
	}
	
	void printInOrder(Node node) {
		if(node.left != null) printInOrder(node.left);
		System.out.print(node.n + " ");
		if(node.right != null) printInOrder(node.right);
	}
	
	void printPostOrder(Node node) {
		if(node.left != null) printInOrder(node.left);
		if(node.right != null) printInOrder(node.right);
		System.out.print(node.n + " ");
		
	}
	
	void printPreOrder(Node node) {
		System.out.print(node.n + " ");
		if(node.left != null) printInOrder(node.left);
		if(node.right != null) printInOrder(node.right);
	}

}
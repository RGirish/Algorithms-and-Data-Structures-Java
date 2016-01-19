
public class Main {

	public static void main(String[] args) {
		BST bst = new BST(10);
		bst.insert(bst.root, 20);
		bst.insert(bst.root, 5);
		bst.insert(bst.root, 12);
		bst.insert(bst.root, 8);
		bst.printInOrder(bst.root);
		System.out.println("");
		bst.printPreOrder(bst.root);
		System.out.println("");
		bst.printPostOrder(bst.root);
	}

}
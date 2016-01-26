
public class Main {

	public static void main(String[] args) {
		BST bst = new BST(40);
		bst.insert(bst.root, 20);
		bst.insert(bst.root, 60);
		bst.insert(bst.root, 10);
		bst.insert(bst.root, 30);
		bst.insert(bst.root, 50);
		bst.insert(bst.root, 70);
		bst.printLevelOrder(bst.root);
	}

}
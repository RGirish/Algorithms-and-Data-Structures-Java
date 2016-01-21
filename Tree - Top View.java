/*
   class Node 
       int data;
       Node left;
       Node right;
*/
void top_view (Node root) {
    printLeft(root.left);
    System.out.print(root.data + " ");
    printRight(root.right);
    
}

void printLeft(Node root){
    if (root.left != null) printLeft (root.left);
    System.out.print(root.data + " ");
}

void printRight(Node root){
    System.out.print(root.data + " ");
    if (root.right != null) printRight (root.right);
}

   /*
    
    class Node 
       int data;
       Node left;
       Node right;
    */

    int max (int a, int b) {
        return (a > b)? a : b;
    }

    int height (Node root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return height(root.right) + 1;
        } else if (root.right == null && root.left != null) {
            return height(root.left) + 1;
        } else {
            return max(height(root.left), height(root.right)) + 1;
        }
    }

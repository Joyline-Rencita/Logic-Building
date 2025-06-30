class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Insert a node in the binary search tree
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // In-order traversal (Left, Root, Right)
    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Delete a node from the binary search tree
    Node deleteNode(Node root, int data) {
        if (root == null) return root;

        // Traverse the tree to find the node to delete
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    // Find the minimum value in the tree
    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Find the maximum value in the tree
    int maxValue(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create the following BST
                  50
               /     \
             30      70
            /  \    /  \
          20   40  60   80 
        */

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Pre-order traversal of the tree:");
        tree.preOrder(tree.root);

        System.out.println("\n\nIn-order traversal of the tree:");
        tree.inOrder(tree.root);

        System.out.println("\n\nPost-order traversal of the tree:");
        tree.postOrder(tree.root);

        System.out.println("\n\nDelete 20");
        tree.root = tree.deleteNode(tree.root, 20);
        System.out.println("In-order traversal of the modified tree:");
        tree.inOrder(tree.root);

        System.out.println("\n\nDelete 30");
        tree.root = tree.deleteNode(tree.root, 30);
        System.out.println("In-order traversal of the modified tree:");
        tree.inOrder(tree.root);

        System.out.println("\n\nDelete 50");
        tree.root = tree.deleteNode(tree.root, 50);
        System.out.println("In-order traversal of the modified tree:");
        tree.inOrder(tree.root);
    }
}

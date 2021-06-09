
public class BinarySearchTree {

    public Node root;

    public void insert(int value) {
        Node node = new Node<>(value);
        // case 1: insert for first node, tree is empty
        if(root == null) {
            root = node;
            return;
        }
        insertRec(root, node);
    }

    // greater than root goes to the right
    // less than root goes to left
    private void insertRec(Node latestRoot, Node node) {
        if(latestRoot.value > node.value) {
            // insert left when nothing is to the left
            if(latestRoot.left == null) {
                latestRoot.left = node;
                return;
            } else {
                // more to be traversed in the tree, will keep going until reaches null value
                insertRec(latestRoot.left, node);
            }
        } else {
            if(latestRoot.right == null) {
                latestRoot.right = node;
                return;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    // returns bottom right node
    public int findMaximum() {
        if(root == null) {
            return 0;
        }
        Node currentNode = root;
        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
    }

    // returns bottom right node
    public int findMaximum(Node currentNode) {
        if(root == null) {
            return 0;
        }
        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
    }

    // returns bottom left node
    public int findMinimum() {
        if(root == null) {
            return 0;
        }
        Node currentNode = root;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public int findMinimum(Node currentNode) {
        if(root == null) {
            return 0;
        }
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // left, then value, then right
    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node currentRoot) {
        if(currentRoot == null) {
            return;
        }
        printInOrderRec(currentRoot.left);
        System.out.print(currentRoot.value + " ");
        printInOrderRec(currentRoot.right);
    }

    // value, then left, then right
    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(Node currentRoot) {
        if(currentRoot == null) {
            return;
        }
        System.out.print(currentRoot.value + " ");
        printInOrderRec(currentRoot.left);
        printInOrderRec(currentRoot.right);
    }

    // left, then right, then root
    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(Node currentRoot) {
        if(currentRoot == null) {
            return;
        }
        printPostOrderRec(currentRoot.left);
        printPostOrderRec(currentRoot.right);
        System.out.print(currentRoot.value + " ");
    }

    public void delete(int key) {
        deleteNodeRec(root, key);
    }

    private Node deleteNodeRec(Node rootNode, int key) {
        if(rootNode == null) {
            System.out.println("No key found in BST");
            return null;
        }
        // walk through tree to find key
        if(key < rootNode.value) {
            rootNode.left = deleteNodeRec(rootNode.left, key);
        } else if(key > rootNode.value) {
            rootNode.right = deleteNodeRec(rootNode.right, key);
        }
        // key matches
        else {
            // no child or only one child
            if(rootNode.left == null) {
                return rootNode.right;
            } else if(rootNode.right == null) {
                return rootNode.left;
            }
            // inorder successor
            rootNode.value = findMinimum(rootNode.right);
            // remove it
            rootNode.right = deleteNodeRec(rootNode.right, rootNode.value);
        }
        return rootNode;
    }

}

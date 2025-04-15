package com.app.sam_backend.config;

public class BST {

    public static void main(String[] args) {
        Node root = new Node(23);

        root.left = new Node(16);
        root.right = new Node(56);

        root.left.left = new Node(8);
        root.left.right = new Node(20);

        System.out.println("Full BST check: " + isBST(root));
        System.out.println("Root-based check: " + isBSTWithRespectToRoot(root));
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // Full BST check
    public static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return isBSTUtil(node.left, min, node.value) &&
                isBSTUtil(node.right, node.value, max);
    }

    // Root-node only check
    public static boolean isBSTWithRespectToRoot(Node root) {
        if (root == null) return true;
        return allLessThan(root.left, root.value) &&
                allGreaterThan(root.right, root.value);
    }

    private static boolean allLessThan(Node node, int value) {
        if (node == null) return true;
        if (node.value >= value) return false;
        return allLessThan(node.left, value) && allLessThan(node.right, value);
    }

    private static boolean allGreaterThan(Node node, int value) {
        if (node == null) return true;
        if (node.value <= value) return false;
        return allGreaterThan(node.left, value) && allGreaterThan(node.right, value);
    }
}

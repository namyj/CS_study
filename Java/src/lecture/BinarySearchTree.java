package lecture;

// 이진 탐색 트리

public class BinarySearchTree {

    private static class Node {
        private int key; // value
        private Node left;
        private Node right;

        public Node (int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // 노드 삽입
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // 노드 삽입의 재귀 메소드
    public Node insertNode(Node node, int key) {
        // 이전 부모 노드의 자식 노드가 null > 노드 삽입
        if (node == null) {
            node = new Node(key);
            return node;
        }

        // 탐색에 성공 > 노드 삽입 X
        if (key == node.key) {
            return node;
        } else if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        }

        return node;
    }

    // 노드 탐색
    public boolean search(int key) {
        return searchNode(root, key);
    }

    // 노드 탐색의 재귀 메소드
    private boolean searchNode(Node node, int key) {
        // 더이상 탐색할 노드 없음
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return searchNode(node.left, key);
        } else {
            return searchNode(node.right, key);
        }
    }

    // 중위 순회
    // left > cur Node > right
    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{50,30,70,20,40,60,80};
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < data.length; i++) {
            bst.insert(data[i]);
        }
        System.out.println("중위순회");
        bst.inorderTraversal();
        System.out.println("");

        System.out.println(bst.search(40));
        System.out.println(bst.search(55));
        System.out.println(bst.search(80));
    }
}

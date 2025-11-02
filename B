import java.util.*;

public class HW1B {
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static void leaves(Node root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        leaves(root.left, leaves);
        leaves(root.right, leaves);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == 0) break;
            root = insert(root, val);
        }

        List<Integer> leaves = new ArrayList<>();
        leaves(root, leaves);
        Collections.sort(leaves);

        for (int i = 0; i < leaves.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(leaves.get(i));
        }
        System.out.println();
    }
}

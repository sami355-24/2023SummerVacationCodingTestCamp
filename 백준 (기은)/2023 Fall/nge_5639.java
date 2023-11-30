import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nge_5639 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int data = Integer.parseInt(br.readLine());
        Node root = new Node(data, null, null);

        String input;
        while(true) {
            input = br.readLine();

            if(input == null || input.equals("")) {
                break;
            }

            int in = Integer.parseInt(input);
            insert(root, in);   
        }

        postorder(root);

        System.out.print(sb);
    }

    static void insert(Node root, int input) {
        if(root.data > input) {
            if(root.left == null) {
                root.left = new Node(input, null, null);
            }

            else {
                insert(root.left, input);
            }
        }

        else {
            if(root.right == null) {
                root.right = new Node(input, null, null);
            }

            else {
                insert(root.right, input);
            }
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void postorder(Node root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        sb.append(root.data).append("\n");
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class nge_1991 {
    static HashMap<String, Node> map = new HashMap<>(); // 노드 저장소
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int nCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < nCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if(left == ".") left = null;
            if(right == ".") right = null;

            Node curr = new Node(data, left, right);

            map.put(data, curr);
        }

        preorder(map.get("A"));
        sb.append("\n");
        inorder(map.get("A"));
        sb.append("\n");
        postorder(map.get("A"));

        System.out.print(sb);
    }

    static void preorder(Node root) {
        if(root != null) {
            sb.append(root.data);
            preorder(map.getOrDefault(root.leftNode, null));
            preorder(map.getOrDefault(root.rightNode, null));
        }
    }

    static void inorder(Node root) {
        if(root != null) {
            inorder(map.getOrDefault(root.leftNode, null));
            sb.append(root.data);
            inorder(map.getOrDefault(root.rightNode, null));
        }
    }

    static void postorder(Node root) {
        if(root != null) {
            postorder(map.getOrDefault(root.leftNode, null));
            postorder(map.getOrDefault(root.rightNode, null));
            sb.append(root.data);
        }
    }

    static class Node {
        String data;
        String leftNode;
        String rightNode;

        public Node(String data, String leftNode, String rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
 
        public Node getLeftNode() {
            return map.getOrDefault(leftNode, null);
        }

        public Node getRightNode() {
            return map.getOrDefault(rightNode, null);
        }
    }
}
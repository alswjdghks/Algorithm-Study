import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Map<Character, Node> map = new HashMap<>();

    static class Node{
        char data;
        Node right;
        Node left;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 7
        StringTokenizer st;

        // 모든 노드 미리 생성
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, new Node(c));
        }

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parentNode = map.get(parent);

            if (left != '.') parentNode.left = map.get(left);
            if (right != '.') parentNode.right = map.get(right);
        }

        Node root = map.get('A');

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb.toString());
    }

    private static void preOrder(Node root){
        if (root == null) return;
        sb.append(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        sb.append(root.data);
        inOrder(root.right);
    }

    private static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        sb.append(root.data);
    }
}

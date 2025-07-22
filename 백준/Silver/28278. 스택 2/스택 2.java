import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            switch (M){
                case 1:
                    int item = Integer.parseInt(st.nextToken());
                    stack.push(item);
                    break;
                case 2:
                    System.out.println(stack.empty() ? -1 : stack.pop());
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
                case 5:
                    System.out.println(stack.empty() ? -1 : stack.peek());
                    break;
                default:
                    break;
            }
        }
    }
}

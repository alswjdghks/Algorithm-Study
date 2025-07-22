import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < T; i++) {
            char[] arr = bf.readLine().toCharArray();
            boolean isRight = true;
            for (int j = 0; j < arr.length; j++) {
                stack1.push(arr[j]);
            }

            for (int j = 0; j < arr.length; j++) {
                if (stack1.peek().equals(')')) {
                    stack2.push(stack1.pop());
                }
                else {
                    stack1.pop();
                    if (stack2.empty()) isRight = false;
                    else stack2.pop();
                }
            }

            if (stack2.empty()){
                if (!isRight) System.out.println("NO");
                else System.out.println("YES");
            } else {
                System.out.println("NO");
                stack2.clear();
            }
        }
    }
}

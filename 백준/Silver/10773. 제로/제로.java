import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(bf.readLine());
            if (N == 0){
                stack.pop();
            }else stack.push(N);
        }
        while (!stack.empty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}

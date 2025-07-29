import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int arr[] = new int[N];
        int num = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2 , 1, 3 인 경우의 반례를 생각해야함
        for (int i = 0 ; i < N ; i++){
            while (!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                num++;
            }
            if (arr[i] == num){
                num++;
            }else {
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty() && stack.peek() == num){
            stack.pop();
            num++;
        }

        if (stack.isEmpty()) sb.append("Nice");
        else sb.append("Sad");

        System.out.println(sb.toString());
    }
}

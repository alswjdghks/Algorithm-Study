import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            String answer;

            if (num1 == 0 && num2 == 0) break;

            int big_num = Math.max(num1, num2);
            if (big_num == num1){ // 첫번째 수가 더 큰 경우
                answer = num1%num2 == 0 ? "multiple" : "neither";
                System.out.println(answer);
            }else {
                answer = num2%num1 == 0 ? "factor" : "neither";
                System.out.println(answer);
            }
        }
        br.close();
    }
}

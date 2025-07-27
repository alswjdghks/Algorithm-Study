import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int N = Integer.parseInt(br.readLine());

            if (N == -1) break;

            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    sb.append(i + " ");
                    sum += i;
                }
            }

            if (sum == N){
                System.out.println(N + " = "+sb.toString().trim().replace(" ", " + ").trim());
            }else {
                System.out.println(N + " is NOT perfect.");
            }

        }
    }
}

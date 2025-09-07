import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] F = new long[N + 1];
        if (N == 1) {
            F[1] = 1;
            System.out.println(1);
        }
        else if (N == 2) {
            F[2] = 2;
            System.out.println(2);
        }
        else {
            F[1] = 1;
            F[2] = 2;
            for (int i = 3; i <= N; i++) {
                F[i] = (F[i - 1] + F[i - 2]) % 15746;
            }
            System.out.println(F[N]);
        }
    }
}

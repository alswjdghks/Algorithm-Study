import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            long N = Long.parseLong(bf.readLine());
            if (N <= 2){
                System.out.println(2);
                continue;
            }
            while (true){
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(N); j++) {
                    if (N % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(N);
                    break;
                }
                N++;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] f;
    public static int count1 = 0;
    public static int count2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        f = new int[N+1];

        fib(N);
        fibonacci(N);
        System.out.println(count1 + " " + count2);

    }
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;
        for (int i = 3 ; i <= n ; i++){
            f[i] = f[i - 1] + f[i - 2];
            count2++;
        }
        return f[n];
    }
}

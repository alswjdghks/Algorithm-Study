import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1][2];
            for (int j = 0; j <= n; j++) {
                fibonacci(j);
            }
            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }
    static void fibonacci(int n) {
        if (n == 0){
            arr[0][0] = 1;
            arr[0][1] = 0;
            return;
        }
        if (n == 1){
            arr[1][0] = 0;
            arr[1][1] = 1;
            return;
        }
        arr[n][0] = arr[n-1][0] + arr[n-2][0];
        arr[n][1] = arr[n-1][1] + arr[n-2][1];
    }
}

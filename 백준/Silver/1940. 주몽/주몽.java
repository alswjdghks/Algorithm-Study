import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int min_idx = 0;
        int max_idx = N-1;
        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        while (min_idx < max_idx) {
            if (arr[min_idx] + arr[max_idx] < M) {
                min_idx++;
            }
            else {
                if (arr[min_idx] + arr[max_idx] == M) {
                    count++;
                }
                max_idx--;
            }
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 10
        int M = Integer.parseInt(st.nextToken()); // 4200
        int sum = 0;
        int[] coin = new int[N];

        for (int i = 0 ; i < N ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i= N-1; i>=0; i--){
            if (M == 0) break;

            if (M / coin[i] != 0){
                sum += M / coin[i];
                M %= coin[i];
            }
        }

        System.out.println(sum);
    }
}

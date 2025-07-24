import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 개수
        int M = Integer.parseInt(st.nextToken()); // 선택할 개수
        int [][] arr = new int[N+1][N+1];

        for (int i = 1 ; i <= N ; i++){
            arr[i][0] = 1;
            arr[i][1] = i;
            arr[i][i] = 1;
        }

        for (int i = 1; i <= N ; i++){
            for (int j = 2 ; j < i ; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        System.out.println(arr[N][M]);

    }
}

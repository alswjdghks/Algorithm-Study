import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] sticker;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine()); // 2
        for(int i = 0 ; i < tc ; i++){
            int N = Integer.parseInt(br.readLine()); // 5
            sticker = new int[2][N];
            dp = new int[2][N];
            for(int j = 0 ; j < 2 ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < N ; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1){
                sb.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
            }else{
                dp[0][0] = sticker[0][0];
                dp[1][0] = sticker[1][0];
                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1];

                for (int j = 2 ; j < N ; j++){
                    dp[0][j] = Math.max( dp[1][j-1] + sticker[0][j], Math.max(dp[1][j-2] + sticker[0][j], dp[0][j-2] + sticker[0][j]));
                    dp[1][j] = Math.max( dp[0][j-1] + sticker[1][j], Math.max(dp[0][j-2] + sticker[1][j], dp[1][j-2] + sticker[1][j]));
                }
                sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
            }
        }
        System.out.println(sb);
    }
}

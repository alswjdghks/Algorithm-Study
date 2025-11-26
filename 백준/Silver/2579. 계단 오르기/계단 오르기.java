import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stair;
    static int[] stair_score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stair = new int[N+1];
        stair_score = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        stair_score[1] = stair[1];

        if (N >= 2){
            stair_score[2] = stair[1] + stair[2];
            for (int i = 3; i <= N; i++) {
                stair_score[i] = Math.max(stair_score[i-2], stair_score[i-3] + stair[i-1]) + stair[i];
            }
        }

        System.out.println(stair_score[N]);

    }
}

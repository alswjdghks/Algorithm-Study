import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] oper;
    static int[] numbers;
    static int N;
    static int M;

    static int max;
    static int min;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine()); // 10
        for (int tc = 1 ; tc <= TC ; tc++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine()); // 5
            M = 0;
            numbers = new int[N];

            oper = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                oper[i] = Integer.parseInt(st.nextToken());
                M += oper[i];
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,numbers[0]);
            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int total){
        if (depth == M){
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        if (oper[0] > 0){
            oper[0]--;
            dfs(depth+1,total + numbers[depth+1]);
            oper[0]++;
        }
        if (oper[1] > 0){
            oper[1]--;
            dfs(depth+1,total - numbers[depth+1]);
            oper[1]++;
        }
        if (oper[2] > 0){
            oper[2]--;
            dfs(depth+1,total * numbers[depth+1]);
            oper[2]++;
        }
        if (oper[3] > 0){
            oper[3]--;
            dfs(depth+1,total / numbers[depth+1]);
            oper[3]++;
        }
    }
}

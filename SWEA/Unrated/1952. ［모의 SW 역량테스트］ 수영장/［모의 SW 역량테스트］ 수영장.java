import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] price;
    static int[] days;
    static StringBuilder sb = new StringBuilder();
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            sb.append("#").append(i).append(" ");
            min = Integer.MAX_VALUE;
            price = new int[4];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            days = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 12; j++) {
                days[j] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            min = Math.min(min, price[3]);
            sb.append(min).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int idx, int total) {
        if (total > min){
            return;
        }

        if (idx >= 12){
            min = Math.min(min, total);
            return;
        }

        dfs(idx+1, total + price[0] * days[idx]);
        dfs(idx+1, total + price[1]);
        dfs(idx+3, total + price[2]);
    }
}

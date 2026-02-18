import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[] trees;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            sb.append("#").append(i).append(" ");
            int N = Integer.parseInt(br.readLine());
            trees = new int[N];
            diff = new int[N];

            int max = Integer.MIN_VALUE;
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                trees[j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[j]);
            }

            int odd = 0; // 홀수
            int even = 0; // 짝수

            for (int j = 0; j < N; j++) {
                diff[j] = max - trees[j];
                odd += diff[j] % 2;
                even += diff[j] / 2;
            }

            while ( even - odd > 1){
                --even;
                odd += 2;
            }

            if (even == odd){
                sb.append(2*even).append("\n");
            }else if(even > odd){
                sb.append(2*even).append("\n");
            }else{
                sb.append(2*odd-1).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

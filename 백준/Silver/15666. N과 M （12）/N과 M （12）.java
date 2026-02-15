import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    static int[] print;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        print = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        permutation(0,0);
        System.out.println(sb.toString());
    }

    private static void permutation(int idx, int start){
        if(idx == M){
            for (int i = 0 ; i < M ; i++){
                sb.append(print[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = Integer.MIN_VALUE;
        for (int i = start ; i < N ; i++){
            if(numbers[i] == prev){continue;}
            print[idx] = numbers[i];
            prev = numbers[i];
            permutation(idx+1,i);
        }
    }
}

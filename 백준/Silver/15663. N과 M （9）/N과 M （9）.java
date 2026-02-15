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
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        print = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        permutation(0);
    }

    private static void permutation(int idx) {
        if (idx == M){
            for (int i = 0; i < M; i++) {
                System.out.print(print[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = Integer.MIN_VALUE; // 이번 depth에서 똑같은 수 사용하는 skip을 위한 수
        for(int i = 0 ; i < N ; i++){
            if(visited[i]) continue;
            if (numbers[i] == prev) continue;
            visited[i] = true;
            print[idx] = numbers[i];
            prev = numbers[i];
            permutation(idx + 1);
            visited[i] = false;
        }

    }
}

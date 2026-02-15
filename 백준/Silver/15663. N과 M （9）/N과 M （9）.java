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
    static int[] visitedNum = new int[10001];

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
            visitedNum[numbers[i]]++;
        }

        Arrays.sort(numbers);
        numbers = Arrays.stream(numbers).distinct().toArray();
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

        for(int i = 0 ; i < numbers.length ; i++){
            if(visitedNum[numbers[i]] > 0){
                visitedNum[numbers[i]]--;
                print[idx] = numbers[i];
                permutation(idx+1);
                visitedNum[numbers[i]]++;
            }
        }

    }
}

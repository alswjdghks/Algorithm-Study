import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자 개수
        int M = Integer.parseInt(st.nextToken()); // 계산 횟수
        int[] A = new int[N+1]; // 배열로 표현
        int[] S = new int[N+1]; // 합배열
        st = new StringTokenizer(bf.readLine());
        for(int i = 1 ; i <= N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + A[i];
        }
        for(int j = 0 ; j < M ; j++){
            st = new StringTokenizer(bf.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            System.out.println(S[lastIndex] - S[startIndex - 1]);
        }
    }
}

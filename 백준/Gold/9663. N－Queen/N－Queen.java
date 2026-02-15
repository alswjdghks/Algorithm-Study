import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] A;
    static int totalCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        totalCnt = 0;
        A = new int[N];

        setQueen(0);
        System.out.println(totalCnt);
    }

    private static void setQueen(int depth) {
        if (depth == N) {
            totalCnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            A[depth] = i;
            if (check(depth)){
                setQueen(depth + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == A[row]) return false;
            if (row - i == Math.abs(A[row] - A[i])) return false;
        }
        return true;
    }
}

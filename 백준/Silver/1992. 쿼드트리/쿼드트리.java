import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] tree;
    static int N;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 8
        tree = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                tree[i][j] = line[j] - '0';
            }
        }

        check(0,0,N);
        System.out.println(sb.toString());
    }

    private static void check(int r, int c, int size) {
        if (size == 1){
            sb.append(tree[r][c]);
            return;
        }

        int value = tree[r][c];
        boolean isSame = true;
        for(int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (tree[i][j] != value) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            sb.append(tree[r][c]);
            return;
        }

        sb.append("(");
        check(r, c , size / 2);
        check(r, c + size / 2, size / 2);
        check(r + size/2 , c, size / 2);
        check(r + size / 2, c + size / 2, size / 2);
        sb.append(")");
    }
}

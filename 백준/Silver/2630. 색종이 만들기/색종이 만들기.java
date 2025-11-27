import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int paper_blue = 0;
    static int paper_white = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0,0,N);
        System.out.println(paper_white);
        System.out.println(paper_blue);
    }

    static void recursive(int x, int y, int n) { // x : 열 , y : 행
        if (isSameColor(x, y, n)) {
            return;
        }

        recursive(x, y, n/2); // 1구역
        recursive(x+n/2, y, n/2); // 2구역
        recursive(x, y+n/2, n/2); // 3구역
        recursive(x+n/2, y+n/2, n/2); // 4구역
    }

    static boolean isSameColor(int x, int y, int n) { // x : 열 , y : 행
        int color = paper[y][x];
        for (int i = y ; i < y + n ; i++){
            for (int j = x ; j < x + n ; j++){
                if (color != paper[i][j]){
                    return false;
                }
            }
        }

        if (color == 1){
            paper_blue++;
        }else{
            paper_white++;
        }
        return true;
    }

}

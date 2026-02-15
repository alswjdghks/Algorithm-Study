import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N*2];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2; j++) {
                map[i][j] = ' ';
            }
        }

        putStar(N-1,0,N);
        printStar(N);
        System.out.println(sb.toString());
    }

    private static void putStar(int r, int c, int size){
        if (size == 3){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 5; j++){
                    if (i == 0){
                        map[r-i][c+j] = '*';
                    }else if(i == 1){
                        if (j % 2 != 0){
                            map[r-i][c+j] = '*';
                        }else {
                            map[r-i][c+j] = ' ';
                        }
                    }else{
                        if (j == 2){
                            map[r-i][c+j] = '*';
                        }else{
                            map[r-i][c+j] = ' ';
                        }
                    }
                }
            }
            return;
        }
        putStar(r-size/2, c + size/2, size/2);
        putStar(r, c, size/2);
        putStar(r, c+size, size/2);
    }

    private static void printStar(int size){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size*2; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }
}

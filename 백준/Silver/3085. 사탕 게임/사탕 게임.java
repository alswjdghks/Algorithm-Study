import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] map;
    static char[][] newMap;
    static int N;
    static int max;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        newMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line =  br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(inRange(ny,nx)){
                        check(i,j,ny,nx);
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static boolean inRange(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void check(int y, int x, int ny, int nx) {
        initMap();
        char temp = newMap[y][x];
        newMap[y][x] = map[ny][nx];
        newMap[ny][nx] = temp;

        for (int i = 0 ; i < N ; i++){
            int count = 1;
            int prev = newMap[i][0];
            for (int j = 1 ; j < N ; j++){
                if (newMap[i][j] == prev){
                    count++;
                    max = Math.max(max,count);
                }else{
                    count = 1;
                    prev = newMap[i][j];
                }
            }
        }

        for (int i = 0; i < N ; i++) {
            int count = 1;
            int prev = newMap[0][i];
            for (int j = 1 ; j < N ; j++){
                if (newMap[j][i] == prev){
                    count++;
                    max = Math.max(max,count);
                }else{
                    count = 1;
                    prev = newMap[j][i];
                }
            }
        }
    }

    private static void initMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
}

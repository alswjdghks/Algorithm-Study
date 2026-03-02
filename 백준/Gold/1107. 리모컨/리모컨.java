import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 숫자
    static int M; // 자리수
    static int min;

    static ArrayList<Integer> can;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        N = Integer.parseInt(line);
        M = line.length();

        min = Math.abs(N - 100);

        can = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            can.add(i);
        }

        int ban = Integer.parseInt(br.readLine());
        if (ban != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < ban; i++) {
                int num = Integer.parseInt(st.nextToken());
                can.removeIf( (integer) -> integer == num );
            }
        }

//        if (can.get(0) == 0) min = Math.min(min, 1+Math.abs(N));

        for (int len = 1 ; len <= 6 ; len++){
            dfs(0,len,0);
        }
        System.out.println(min);
    }

    private static void dfs(int index, int targetLen, int value){
        if (index == targetLen){
            min = Math.min(min, targetLen + Math.abs(N - value));
            return;
        }
        for(int i : can){
            if (index == 0 && targetLen > 1 && i == 0){continue;} // 001 같은거 금지
            dfs(index+1,targetLen,value * 10 + i);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a;
    static long b;
    static int min;
    static boolean isThere;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        isThere = false;
        min = Integer.MAX_VALUE;
        dfs(a, 1);

        System.out.println(isThere ? min : -1);
    }

    private static void dfs(long value, int count){
        if (value > b){
            return;
        }
        if (value == b){
            min = Math.min(min, count);
            isThere = true;
            return;
        }
        dfs(value * 2 , count+1);
        dfs(value * 10 + 1, count+1);
    }
}

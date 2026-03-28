import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int maxA = a, maxB = b, maxC = c;
        int minA = a, minB = b, minC = c;

        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int v3 = Integer.parseInt(st.nextToken());

            int newMaxA = v1 + Math.max(maxA, maxB);
            int newMaxB = v2 + Math.max(maxB, Math.max(maxA, maxC));
            int newMaxC = v3 + Math.max(maxB, maxC);

            int newMinA = v1 + Math.min(minA, minB);
            int newMinB = v2 + Math.min(minB, Math.min(minA, minC));
            int newMinC = v3 + Math.min(minB, minC);

            maxA = newMaxA; maxB = newMaxB; maxC = newMaxC;
            minA = newMinA; minB = newMinB; minC = newMinC;
        }

        int max = Math.max(maxA, Math.max(maxB, maxC));
        int min = Math.min(minA, Math.min(minB, minC));

        System.out.println(max + " " + min);
    }
}

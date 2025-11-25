import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> listen = new ArrayList<>(); // 듣도 못한 사람
        for (int i = 0; i < N; i++) {
            listen.add(br.readLine());
        }

        List<String> seen = new ArrayList<>(); // 보도 못한 사람
        for (int i = 0; i < M; i++) {
            seen.add(br.readLine());
        }

        Collections.sort(listen);
        Collections.sort(seen);

        int count = 0;
        List<String> small = N > M ? seen : listen;
        List<String> big = N > M ? listen : seen;
        StringBuilder sb = new StringBuilder();

        for (String s : small) {
            if (Collections.binarySearch(big,s) >= 0) {
                count++;
                sb.append(s).append("\n");
            }
        }
        System.out.println(count);
        System.out.print(sb.toString());
    }
}

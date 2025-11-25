import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 26
        int M = Integer.parseInt(st.nextToken()); // 5

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String pocketMon = br.readLine();
            arr[i] = pocketMon;
            map.put(pocketMon, i);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            if (Character.isDigit(problem.charAt(0))) { // 숫자
                sb.append(arr[Integer.parseInt(problem)]).append("\n");
            }else { // 문자
                sb.append(map.get(problem)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}

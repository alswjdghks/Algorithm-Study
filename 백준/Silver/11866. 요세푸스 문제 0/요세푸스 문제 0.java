import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 7
        int idx_size = Integer.parseInt(st.nextToken()); // 3
        
        List<Integer> list = new ArrayList<>(); // 1000
        List<Integer> list_print = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            idx = (idx + (idx_size-1)) % list.size(); 
            list_print.add(list.get(idx));
            list.remove(idx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < list_print.size()-1; i++) {
            sb.append(list_print.get(i)+", ");
        }
        sb.append(list_print.get(list_print.size()-1) + ">");

        System.out.println(sb.toString());
    }
}

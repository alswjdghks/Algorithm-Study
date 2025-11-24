import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 23
        int[] T_arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < 6 ; i++){
            T_arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int T_group = 0;
        int P_group = 0;
        int P_solo = 0;

        for(int i = 0 ; i < 6 ; i++){
            int plus = (T_arr[i] % T == 0) ? (T_arr[i] / T) : (T_arr[i] / T + 1);
            T_group += plus;
        }
        System.out.println(T_group);

        P_group = N / P;
        P_solo = N - ( P_group * P );
        System.out.println(P_group + " " + P_solo);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] count_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        count_arr = new int[N+1];

        if (N == 0 || N == 1){
            System.out.println(0);
        } else if (N == 2 || N == 3) {
            System.out.println(1);
        } else {
            count_arr[0] = 0;
            count_arr[1] = 0;
            count_arr[2] = 1;
            count_arr[3] = 1;
            for (int i = 4 ; i <= N ; i++) {
                change_count(i);
            }
            System.out.println(count_arr[N]);
        }
    }

    static void change_count(int n){
        int min = Integer.MAX_VALUE;

        if (n % 3 == 0 ){
            min = count_arr[n/3] + 1;
        }
        if (n % 2 == 0){
            min = Math.min(min, count_arr[n / 2] + 1);
        }

        int default_count =  count_arr[n-1] + 1;
        count_arr[n] = Math.min(default_count, min);
    }
}

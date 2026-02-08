import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int H_idx;
    static int OH_idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int H = N-1;
        int OH = 0;
        int min = Integer.MAX_VALUE;

        if (arr[H] <= 0){
            System.out.println(arr[H-1] + " " + arr[H]);
            return;
        }
        
        if (arr[OH] >= 0){
            System.out.println(arr[OH] + " " + arr[OH+1]);
            return;
        }

        while (H > OH){
            int val = arr[H] + arr[OH];
            if (Math.abs(val) < min){
                min = Math.abs(val);
                H_idx = H;
                OH_idx = OH;
            }
            if (val < 0){
                OH++;
            }else if(val > 0){
                H--;
            }else{
                break;
            }
        }
        System.out.println(arr[OH_idx] + " " + arr[H_idx]);
    }
}

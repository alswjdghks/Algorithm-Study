import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = 1; // 총합 초기화
        int count = 1; // 자기 자신
        int start_index = 1;
        int end_index = 1;
        while(end_index != N){
            if(sum == N) {
                count++;
                end_index++;
                sum += end_index;
            }
            else if(sum < N){
                end_index++;
                sum += end_index;
            }
            else{
                sum -= start_index; // 주의
                start_index++;
            }
        }
        System.out.println(count);
    }
}
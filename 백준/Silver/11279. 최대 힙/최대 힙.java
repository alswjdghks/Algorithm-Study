import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if (M == 0){
                if (pq.isEmpty()){
                    System.out.println(0);
                }else {
                    int num = pq.poll();
                    System.out.println(num);
                }
            }else {
                pq.add(M);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int abs_first = Math.abs(o1);
            int abs_second = Math.abs(o2);
            if (abs_first == abs_second) { // 절대값이 같은 경우
                return o1 > o2 ? 1 : -1;
            }
            return abs_first-abs_second; // 절대값이 작은 데이터 우선
        });
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(bf.readLine());
            if (M == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }else {
                    System.out.println(pq.poll());
                }
            }else {
                pq.add(M);
            }
        }
    }
}

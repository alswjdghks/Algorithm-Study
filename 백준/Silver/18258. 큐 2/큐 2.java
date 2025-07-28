import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(); // 출력 속도 최적화
        int back = 0;
        int value = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("pop")){
                value = queue.isEmpty() ? -1 : queue.poll();
                sb.append(value + "\n");
            }else if (str.equals("size")){
                sb.append(queue.size() + "\n");
            }else if (str.equals("empty")){
                value = queue.isEmpty() ? 1 : 0;
                sb.append(value + "\n");
            }else if (str.equals("front")){
                value = queue.isEmpty() ? -1 : queue.peek();
                sb.append(value + "\n");
            }else if (str.equals("back")){
                value = queue.isEmpty() ? -1 : back;
                sb.append(value + "\n");
            }else {
                String[] arr = str.split(" ");
                back = Integer.parseInt(arr[arr.length - 1]);
                queue.add(back);
            }
        }
        System.out.println(sb.toString().trim());
    }
}

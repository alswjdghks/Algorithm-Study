import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int addNum;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    addNum = Integer.parseInt(st.nextToken());
                    deque.addFirst(addNum);
                    break;
                case 2:
                    addNum = Integer.parseInt(st.nextToken());
                    deque.addLast(addNum);
                    break;
                case 3:
                    System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());
                    break;
                case 4:
                    System.out.println(deque.isEmpty() ? -1 : deque.removeLast());
                    break;
                case 5:
                    System.out.println(deque.size());
                    break;
                case 6:
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case 7:
                    System.out.println(deque.isEmpty() ? -1 : deque.getFirst());
                    break;
                case 8:
                    System.out.println(deque.isEmpty() ? -1 : deque.getLast());
                    break;
            }
        }
    }
}

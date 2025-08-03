import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int value;
        int index;

        Balloon(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Balloon> deque = new ArrayDeque<>();
        Balloon[] balloons = new Balloon[N];
        int value;
        int arrIndex = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.add(new Balloon(Integer.parseInt(st.nextToken()), i+1));
        }

        while (!deque.isEmpty()) {
            Balloon balloon = deque.removeFirst();
            balloons[arrIndex++] = balloon;
            value = balloon.value;

            if (deque.isEmpty()) break;

            if (value > 0){
                for (int j = 0 ; j < value-1 ; j++){
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int j = 0 ; j < -value ; j++){
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        for (Balloon balloon : balloons) {
            System.out.print(balloon.index + " ");
        }
    }
}

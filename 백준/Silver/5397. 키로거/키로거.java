import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 2
        for (int i = 0; i < N; i++) {
            LinkedList<Character> list = new LinkedList<Character>();
            ListIterator<Character> listIterator = list.listIterator();
            char[] arr = br.readLine().toCharArray();
            for (char c : arr) {
                 if (c == '<') {
                     if (listIterator.hasPrevious()) {
                         listIterator.previous();
                     }
                 }else if (c == '>') {
                     if (listIterator.hasNext()) {
                         listIterator.next();
                     }
                 }else if(c == '-') {
                     if (listIterator.hasPrevious()) {
                         listIterator.previous();
                         listIterator.remove();
                     }
                 }else {
                     listIterator.add(c);
                 }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        
        }
        br.close();
    }
}

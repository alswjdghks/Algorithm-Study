import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder first_num = new StringBuilder();
        StringBuilder second_num = new StringBuilder();

        int num1 = Integer.parseInt(first_num.append(st.nextToken()).reverse().toString());
        int num2 = Integer.parseInt(second_num.append(st.nextToken()).reverse().toString());

        System.out.println(Math.max(num1, num2));
    }
}

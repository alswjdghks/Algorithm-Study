import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i< num ; i++){

            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());

            String str = st.nextToken();
            String result = "";
            for (int j = 0 ; j< str.length() ; j++){
                String c = str.charAt(j) + "";
                result += c.repeat(count);
            }
            System.out.println(result);
        }
    }
}

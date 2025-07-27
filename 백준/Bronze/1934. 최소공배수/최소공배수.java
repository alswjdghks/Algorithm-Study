import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (num1 >= num2) {
                System.out.println(LCM(num1, num2));
            }else {
                System.out.println(LCM(num2, num1));
            }
        }
    }
    private static int GCD(int num1,int num2){
        if (num1 % num2 == 0){
            return num2;
        }
        return GCD(num2, num1%num2);
    }

    private static int LCM(int num1,int num2){
        return num1*num2 / GCD(num1,num2);
    }
}

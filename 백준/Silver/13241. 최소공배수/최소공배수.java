import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        System.out.println(LCM(N,M));
    }
    private static long GCD(long num1,long num2){
        if (num1 % num2 == 0){
            return num2;
        }
        return GCD(num2, num1%num2);
    }

    private static long LCM(long num1,long num2){
        return num1*num2 / GCD(num1,num2);
    }
}


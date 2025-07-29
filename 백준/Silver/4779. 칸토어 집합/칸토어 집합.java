import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String spaceBar = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            System.out.println(cantore(N));
        }
    }

    private static String cantore(int n){
        if (n == 0) return "-";
        return cantore(n-1) + spaceBar.repeat((int) Math.pow(3,n-1))  +cantore(n-1);
    }
}

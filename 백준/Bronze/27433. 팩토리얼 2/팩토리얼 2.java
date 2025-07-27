import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
        sc.close();
    }
    private static long factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return factorial(n-1) * n;
    }
    
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            System.out.println(isPalindrome(str) + " " +count);
            count = 0;
        }
    }

    public static int recursion(String s, int start, int end){
        count++;
        if (start >= end) return 1;
        else if (s.charAt(start) != s.charAt(end)) return 0;
        else return recursion(s, start + 1, end-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}

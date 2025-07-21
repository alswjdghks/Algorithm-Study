import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        for(char c = 'a'; c <= 'z' ; c++){
            System.out.print(str.indexOf(c + "")+" ");
        }
    }
}

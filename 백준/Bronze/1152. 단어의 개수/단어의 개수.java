import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().trim();
        if (str.equals("")) {
            System.out.println(0);
        }else {
            System.out.println(str.split(" ").length);
        }
    }
}

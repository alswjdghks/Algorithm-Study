import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int [][][] arr = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 21; j++) {
            for (int k = 0; k < 21; k++) {
                arr[0][j][k] = 1;    // a = 0
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int k = 0; k < 21; k++) {
                arr[i][0][k] = 1;   // b = 0
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                arr[i][j][0] = 1;  // c = 0
            }
        }

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k < 21; k++) {
                    // a > b
                    arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                }
            }

            for (int j = i+1; j < 21; j++) {
                for (int k = 1; k <= j; k++) {
                    // a < b , b > c
                    arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                }

                for (int k = j+1; k < 21; k++) {
                    // a < b < c
                    arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
                }
            }
        }

        while (true){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == -1 && B == -1 && C == -1){
                break;
            }
            // w(1, 1, 1) = 2
            if (A <= 0 || B <= 0 || C <= 0){
                System.out.println("w("+A+", "+B+", "+C+") = " + 1);
            }
            else if (A > 20 || B > 20 || C > 20){
                System.out.println("w("+A+", "+B+", "+C+") = " + arr[20][20][20]);
            }
            else {
                System.out.println("w("+A+", "+B+", "+C+") = " + arr[A][B][C]);
            }
        }


    }
}

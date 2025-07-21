import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < count ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > maxValue){
                maxValue = num;
            }
            sum += num;
        }
        System.out.println(sum  * 100.0 / maxValue / count);
    }
}

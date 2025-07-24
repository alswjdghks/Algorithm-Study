import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int A[] = new int[N];
        int num = 1;
        boolean result = true;
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        
        for(int i = 0 ; i < N ; i++) {
            int su = A[i];
            if(su >= num) {
                while(su >= num){
                    st.push(num++);
                    sb.append("+\n");    
                }
                st.pop();
                sb.append("-\n");
            }
            else {
                if(st.pop() > su){
                    result = false;
                    System.out.println("NO");
                    break;
                } else sb.append("-\n");
            }
        }
        
        if(result){
            System.out.println(sb.toString());
        }
        
    }
}
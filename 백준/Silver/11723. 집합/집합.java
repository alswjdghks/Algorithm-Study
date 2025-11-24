import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    /*
      * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
      * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
      * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
      * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
      * all: S를 {1, 2, ..., 20} 으로 바꾼다.
      * empty: S를 공집합으로 바꾼다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();

            if (cal.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            } else if(cal.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                set.remove(num);
            } else if(cal.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            } else if (cal.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)){
                    set.remove(num);
                }else {
                    set.add(num);
                }
            } else if (cal.equals("all")) {
                set.clear();
                for (int j = 1; j < 21 ; j++){
                    set.add(j);
                }
            } else { // empty
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }
}

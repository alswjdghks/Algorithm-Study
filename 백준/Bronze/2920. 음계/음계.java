import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> origin = new ArrayList<>();
        List<Integer> replica = new ArrayList<>();
        List<Integer> replica2 = new ArrayList<>();

        for (int i = 0 ; i < 8 ; i++){
            int num = Integer.parseInt(st.nextToken());
            origin.add(num);
            replica.add(num);
            replica2.add(num);
        }

        Collections.sort(replica);
        replica2.sort(Collections.reverseOrder());

        if (origin.equals(replica)){
            System.out.println("ascending");
        }else if(origin.equals(replica2)){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static int N;
	public static int K;
	public static int answer;
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 657
		K = Integer.parseInt(st.nextToken()); // 1 ~ 3
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		dfs(0);
		System.out.println(answer);
	}
	
	
	private static void dfs(int total) {
		if (total > N) {
			return;
		}
		if(total > answer) {
			answer = total;
		}
		for(int i = list.size()-1 ; i >= 0 ; i--) {
			dfs(list.get(i) + total * 10);
		}
	}
}
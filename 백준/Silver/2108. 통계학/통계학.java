import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) { // 50만번
            int M = Integer.parseInt(br.readLine());
            arr[i] = M;
        }

        Arrays.sort(arr); // n * log n -> 50만번 * 5 = 250만번

        System.out.println(Math.round(Arrays.stream(arr).average().orElse(0))); // 산술평균
        System.out.println(arr[N/2]); // 중앙값

        // 최빈값
        int many_count = 0;
        Map<Integer, Integer> count = new HashMap<>();

        Arrays.stream(arr).forEach(n -> count.put(n, count.getOrDefault(n, 0) + 1)); // 50만번
        int many = Collections.max(count.values()); // 최대 개수
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == many) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        if (list.size() == 1){
            many_count = list.get(0);
        }else{
            many_count = list.get(1);
        }
        System.out.println(many_count); // 최빈값
        System.out.println(arr[arr.length - 1] - arr[0]); // 범위
    }
}

import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean[] v;
    static int len;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        A = new ArrayList[n+1];
        v = new boolean[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            A[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < computers.length ; i++){
            for(int j = 0 ; j < computers[i].length ; j++){
                if(i != j && computers[i][j] == 1){
                    A[i+1].add(j+1);
                }
            }
        }
        
        for(int i = 1 ; i<= n ; i++){
            if(!v[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        v[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : A[cur]){
                if(!v[next]){
                    v[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

}
import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] value;
    static ArrayList<Integer>[] A;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        value = new int[n+1];
        A = new ArrayList[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0 ; i < edge.length ; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            A[start].add(end);
            A[end].add(start);
        }
        
        int max = bfs(1);
        for(int i = 1; i <= n ; i++){
            if ( value[i] == max ) answer++;
        }
        return answer;
    }
    
    private static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        value[start] = 1;
        int max = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : A[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    value[next] = value[cur] + 1;
                    max = Math.max(max, value[next]);
                    queue.offer(next);
                }
            }
        }
        return max;
    }
}
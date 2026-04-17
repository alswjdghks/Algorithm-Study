import java.util.*;
class Solution {
    static ArrayList<Integer>[] A;
    static ArrayList<Integer>[] A_reverse;
    static int N;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        A = new ArrayList[n+1];
        A_reverse = new ArrayList[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            A[i] = new ArrayList<Integer>();
            A_reverse[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0 ; i < results.length ; i++){
            int start = results[i][0];
            int end = results[i][1];
            
            A[start].add(end);
            A_reverse[end].add(start);
        }
        
        for(int i = 1; i <= n ; i++){
            int win = bfs(i,A);
            int lose = bfs(i,A_reverse);
            if(win + lose == N-1){
                answer++;
            }
        }
        
        return answer;
    }
    
    private static int bfs(int start, ArrayList<Integer>[] list){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        int count = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}
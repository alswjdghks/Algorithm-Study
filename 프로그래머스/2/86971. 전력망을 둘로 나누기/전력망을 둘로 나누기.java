import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        A = new ArrayList[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            A[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            int left = wires[i][0];
            int right = wires[i][1];
            
            A[left].add(right);
            A[right].add(left);
        }
        
        
        for(int i = 0 ; i < wires.length ; i++){
            int left = wires[i][0];
            int right = wires[i][1];
            
            A[left].remove(Integer.valueOf(right));
            A[right].remove(Integer.valueOf(left));
            
            int count_left = bfs(left,n);
            int count_right = bfs(right,n);
            
            answer = Math.min(answer, Math.abs(count_left - count_right));
            
            A[left].add(right);
            A[right].add(left);
        }
        return answer;
    }
    
    private static int bfs(int num, int n){
        boolean visited[] = new boolean[n+1];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count += 1;
            visited[cur] = true;
            
            for(int next : A[cur]){
                if(!visited[next]){
                    queue.offer(next);
                }
            }
        }
        return count;
    }
    
}
import java.util.*;

class Solution {
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int n; // 세로
    static int m; // 가로
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        int[] start = new int[]{0,0};
        bfs(start, maps);
        
        answer = maps[n-1][m-1];
        answer = answer == 1 ? -1 : answer;
        return answer;
    }
    
    private static void bfs(int[] start, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];
            for(int d = 0 ; d < 4 ; d++){
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(inRange(ny,nx) && maps[ny][nx] != 0 && !visited[ny][nx]){
                    maps[ny][nx] = maps[cy][cx] + 1;
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny,nx});
                }
            }
        }
    }
    
    private static boolean inRange(int y, int x ){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
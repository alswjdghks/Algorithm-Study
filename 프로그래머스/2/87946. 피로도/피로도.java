class Solution {
    static int N;
    static boolean[] visited;
    static int[][] d;
    static int[][] dg;
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dg = dungeons;
        N = dungeons.length;
        visited = new boolean[N];
        d = new int[N][2];
        
        dfs(0,k);
        
        answer = max;
        return answer;
    }
    
    private static void dfs(int index, int piro){
        if(index == N){
            int count = check(d, piro);
            max = Math.max(count,max);
            return;
        }
        for(int i = 0 ; i < N ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            d[index] = dg[i];
            dfs(index+1, piro);
            visited[i] = false;
        }
    }
    
    private static int check(int[][] dungeon, int piro){
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            if(dungeon[i][0] <= piro){
                count++;
                piro -= dungeon[i][1];
            }else{
                break;
            }
        }
        return count;
    }
}
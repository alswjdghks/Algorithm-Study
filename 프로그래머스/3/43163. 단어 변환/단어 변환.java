class Solution {
    static boolean[] visited;
    static int minValue;
    static String targetWord;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        minValue = Integer.MAX_VALUE;
        
        targetWord = target;
        dfs(0,begin,0,words);
        answer = minValue == Integer.MAX_VALUE ? 0 : minValue;
        return answer;
    }
    
    private static void dfs(int index, String lastWord, int count, String[] words){
        if(lastWord.equals(targetWord)){
            minValue = Math.min(count,minValue);
            return;
        }
        if(index == words.length){
            if(lastWord.equals(targetWord)){
                minValue = Math.min(count, minValue);
            }
            return;
        }
        for(int i = 0 ; i < words.length ; i++){
            if(visited[i]) continue;
            String currentWord = words[i];
            int cnt = 0;
            
            for(int j = 0 ; j < currentWord.length() ; j++){
                if(currentWord.charAt(j) != lastWord.charAt(j)){
                    cnt++;
                }
            }
            
            if(cnt == 1){
                visited[i] = true;
                dfs(index+1, currentWord, count+1, words);
                visited[i] = false;
            }
        }
    }
}
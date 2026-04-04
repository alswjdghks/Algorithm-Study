import java.util.*;
class Solution {
    static String[] alphabet = {"A","E","I","O","U"};
    static ArrayList<String> directory;
    public int solution(String word) { 
        directory = new ArrayList<String>();
        dfs("");
        int answer = directory.indexOf(word) + 1;
        return answer;
    }
    
    private static void dfs(String s){
        if(s.length() > 5) return;
        
        if (!s.isEmpty()) {
            directory.add(s);
        }
        
        for(int i = 0 ; i < 5 ; i++){
            dfs(s + alphabet[i]);
        }
    }
}
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        ArrayList<Integer> max = new ArrayList<>();
        ArrayList<Integer> min = new ArrayList<>();
        for(int i = 0 ; i < sizes.length ; i++){
            max.add(Math.max(sizes[i][0], sizes[i][1]));
            min.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        
        int max_d = Collections.max(max);
        int min_d = Collections.max(min);
        System.out.print(max_d + " " + min_d);
        answer = max_d * min_d;
        
        return answer;
    }
}
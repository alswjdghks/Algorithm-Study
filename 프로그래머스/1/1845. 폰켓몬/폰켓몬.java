import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int max = nums.length / 2;
        for(int pocketmon : nums){
            set.add(pocketmon);
        }
        answer = set.size() <= max ? set.size() : max;
        return answer;
    }
}
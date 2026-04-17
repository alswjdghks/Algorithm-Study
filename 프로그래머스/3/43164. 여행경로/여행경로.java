import java.util.*;

class Solution {
    static Map<String, Integer> airport = new HashMap<>();
    static int airportNum = 1;
    static int airportCnt;
    static int ticketCnt;
    static ArrayList<String>[] A;
    
    public String[] solution(String[][] tickets) {
        airport.put("ICN",airportNum++);
        ticketCnt = tickets.length;
        
        for(int i = 0 ; i < tickets.length ; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(!airport.containsKey(start)){
                airport.put(start, airportNum++);
            }            
            if(!airport.containsKey(end)){
                airport.put(end, airportNum++);
            }
        }
        
        airportCnt = airport.keySet().size();
        A = new ArrayList[airportCnt+1];
        
        for(int i = 0 ; i <= airportCnt ; i++){
            A[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < tickets.length ; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            A[airport.get(start)].add(end);
        }
        
        for(int i = 1 ; i <= airportCnt ; i++){
            Collections.sort(A[i]);
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN"); // 이 부분 수정
        
        String[] answer = dfs(0,"ICN",list);
        return answer;
    }
    
    private static String[] dfs(int index, String current, ArrayList<String> list){
        if(index == ticketCnt){
            return list.toArray(new String[list.size()]);
        }
        
        // 현재 공항에서 갈 수 있는 곳이 없는 경우 (예외 처리)
        if (!airport.containsKey(current) || A[airport.get(current)].isEmpty()) {
            return null;
        }
        
        int current_airport_number = airport.get(current);
        
        for (int i = 0; i < A[current_airport_number].size(); i++) {
            // 1. 사용할 공항을 꺼내고 리스트에서 잠시 제거 (티켓 사용)
            String next = A[current_airport_number].remove(i);
            list.add(next);

            // 2. 재귀 호출
            String[] result = dfs(index + 1, next, list);
            if (result != null) return result; // 경로를 찾았으면 바로 반환

            // 원상복구 (중요!)
            // 다른 경로를 탐색하기 위해 방금 뺐던 티켓을 다시 제자리에 넣음
            list.remove(list.size() - 1);
            A[current_airport_number].add(i, next);
        }
        return null;
    }
}
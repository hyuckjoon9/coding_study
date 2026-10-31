import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        // 쌍(이름, 1)
        // 같은 이름은?
        // 쌍(이름, 중복수)
        
        /*
        completion 돌면서 나온 이름 value-1
        
        participant 돌면서 value가 0이 아니면 return
        */
        
        for(String s : participant){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        for(String s : completion){            
            map.put(s, map.get(s)-1);
        }
        
        for(String s : participant){
            if(map.get(s)!=0) return s;
        }
        
        
        
        
        return answer;
    }
}
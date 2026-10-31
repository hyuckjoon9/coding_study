import java.util.*;
class Solution {        
    List<int[]> list=new ArrayList<>();    
    public int[][] solution(int n) {        
        hanoi(n,1,3,2);
        
        
        
        return list.toArray(new int[0][]);
    }
    /*
    1 3 2
    
    1 2 3       1,2
    
        
    */
    public void hanoi(int n, int from, int to, int sub){
        if(n==0) return;
        
        // 보조기둥으로
        hanoi(n-1, from, sub, to);
        
        // 제일 큰 원판 목표 기둥으로.
        list.add(new int[]{from,to});
        
        // 목표기둥으로
        hanoi(n-1, sub, to, from);
    }
    
}
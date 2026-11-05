import java.util.*;

class Solution {
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1,3,2);
        return list.toArray(new int[0][]);
    }
    
    public void hanoi(int n, int start, int target, int sub){
        if(n==0) return;
        
        hanoi(n-1, start, sub, target);
        list.add(new int[]{start, target});
        hanoi(n-1, sub,target,start);
    }
}
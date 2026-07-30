import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        Set<Integer>[] dp = new HashSet[9];
        for(int i=0;i<9;i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        
        int connect=0;
        for(int count=1;count<9;count++){
            dp[count].add(connect * 10 + N);
            connect = connect * 10 + N; 
            
            for(int leftCnt=1 ; leftCnt < count ; leftCnt++){
                int rightCnt = count-leftCnt;
                
                for(int v1 : dp[leftCnt]){
                    for(int v2 : dp[rightCnt]){                    
                        dp[count].add(v1+v2);
                        dp[count].add(v1-v2);
                        dp[count].add(v1*v2);
                        if(v2!=0) dp[count].add(v1/v2);
                    }
                }
            }
            if(dp[count].contains(number)) return count;     
        }
        
        return -1;
    }
}
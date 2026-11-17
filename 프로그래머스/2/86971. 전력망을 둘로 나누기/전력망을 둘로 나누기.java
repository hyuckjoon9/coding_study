import java.util.*;
class Solution {
    boolean[][] graph;
    int root;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        visited = new boolean[n+1];
        graph = new boolean[n+1][n+1];
        
        // 1. 그래프 생성
        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];
            
            graph[u][v]=true;
            graph[v][u]=true;
        }
        
        for(int[] wire : wires){
            // 2. 간선 끊기
            int u = wire[0];
            int v = wire[1];
            
            graph[u][v]=false;
            graph[v][u]=false;
            
            // 3. 방문 배열 초기화
            Arrays.fill(visited,false);
            
            // 4. 연결 노드 계산
            int cnt = dfs(u);
            
            // 5. 두 전력망 차이 계산
            int diff = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer,diff);
            
            // 6. 간선 복구.
            graph[u][v]=true;
            graph[v][u]=true;
        }
        
        return answer;
    }
    
    public int dfs(int node){
        visited[node]=true;
        int cnt=1;
        
        for(int i=0;i<graph.length;i++){
            if(!visited[i] && graph[node][i]==true){
                visited[i]=true;                
                cnt+=dfs(i);
            }
        }
        
        return cnt;
    }
}
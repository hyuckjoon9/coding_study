import java.util.*;
class Solution {
    List<List<Integer>> list;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        // 1. 그래프 만들기
        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];
            
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        for(int[] wire : wires){
            // 2. 끊을 간선 구하기
            int u = wire[0];
            int v = wire[1];
            
            // 3. 연결 노드 갯수 구하기
            Arrays.fill(visited, false);
            int cnt = dfs(u, u,v);
            
            // 4. 두 전력망 차이 구하기
            int diff = Math.abs(cnt - (n-cnt));
            answer = Math.min(answer , diff);
        }
        
        return answer;
    }
    
    public int dfs(int node, int blockedU, int blockedV){
        visited[node]=true;
        int cnt = 1;
        
        for(int next : list.get(node)){
            if((next == blockedU && node == blockedV) || (next == blockedV && node == blockedU))
                continue;
            if(visited[next]) continue;
            
            cnt += dfs(next, blockedU, blockedV);
        }
        
        return cnt;
    }
}
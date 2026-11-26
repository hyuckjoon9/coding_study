import java.util.*;

class Solution {
    List<List<Integer>> graph;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        
        // 리스트로 전력망 연결.
        for(int[] wire : wires){
            int u = wire[0];
            int v = wire[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // 전력망 나눔.
        for(int[] wire : wires){
            Arrays.fill(visited,false);
            int u = wire[0];
            int v = wire[1];
            
            int cnt = dfs(u, u, v);
            int diff = cnt - (n - cnt);
            answer = Math.min(answer , Math.abs(diff));
        }
        
        return answer;
    }
    
    public int dfs(int node, int start, int end){
        if(visited[node]) return 0;
        
        int cnt = 1;
        visited[node]=true;
        
        for(int v : graph.get(node)){
            if(visited[v] || v == end) continue;
            
            cnt += dfs(v, start, end);
        }
        
        return cnt;
    }
}

/*
리스트로 전력망 연결

전력망 나눔.

dfs로 하나의 전력망 송전탑 갯수 구함.
나머지는 전체 송전탑에서 빼서 구함


*/
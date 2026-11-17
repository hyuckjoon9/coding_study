import java.util.*;
class Solution {
    boolean[][] graph;
    int root;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        visited = new boolean[n+1];
        graph = new boolean[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u][v]=true;
            graph[v][u]=true;
        }
        
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]==true){
                    graph[i][j]=false;
                    graph[j][i]=false;
                    
                    int v1 = dfs(i);
                    int v2 = n-v1;
                    answer = Math.min(answer, Math.abs(v1-v2));
                    
                    Arrays.fill(visited,false);
                    graph[i][j]=true;
                    graph[j][i]=true;
                }
            }
        }
        
        return answer;
    }
    
    public int dfs(int node){
        int cnt=0;
        
        for(int i=0;i<graph.length;i++){
            if(!visited[i] && graph[node][i]==true){
                visited[i]=true;
                cnt++;
                cnt+=dfs(i);
            }
        }
        
        return cnt;
    }
}
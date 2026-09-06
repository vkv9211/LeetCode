import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        int province = 0;

        boolean[] visited = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if( i== j){
                    continue;
                }
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        for(int i =0;i<n;i++){
            if(!visited[i]){
                province++;
                dfs(i,visited,adj);
            }
        }

        return province;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        for(Integer i : adj.get(node)){
            if(!visited[i]){
                dfs(i, visited, adj);
            }
        }
    }
}
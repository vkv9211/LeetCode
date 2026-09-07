class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] check = new boolean[V];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            for(int x : graph[i]){
                adj.get(i).add(x);
            }
        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,path,check,adj);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] path, boolean[] check, List<List<Integer>> adj){
        visited[node] = true;
        path[node] = true;

        for(int i: adj.get(node)){
            if(!visited[i]){
                if(dfs(i, visited, path, check, adj)){
                    return true;
                }
            }else if(path[i]){
                return true;
            }
        }
        check[node] = true;
        path[node] = false;
        return false;
    }
}
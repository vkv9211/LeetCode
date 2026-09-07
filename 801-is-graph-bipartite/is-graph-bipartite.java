import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        List<List<Integer>> list = new ArrayList<>();

        int row = graph.length;
        for(int i=0;i<row;i++){
            list.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                list.get(i).add(neighbor);
            }
        }

        int[] color = new int[row];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<row;i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(Integer l : list.get(temp)){
                        if(color[l] ==-1){
                            color[l] = 1-color[temp];
                            q.add(l);
                        }else if(color[l] == color[temp]){
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }
}
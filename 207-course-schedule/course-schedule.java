class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree,0);

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            for(Integer l: adj.get(temp)){
                indegree[l]--;
                if(indegree[l] == 0){
                    q.add(l);
                }
            }
        }

        return count==numCourses;
    }
}
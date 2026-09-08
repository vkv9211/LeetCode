class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] ans = new int[numCourses];
        int var =0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int courses =0;

        while(!q.isEmpty()){
            int temp = q.poll();
            courses++;
            ans[var++] = temp;

            for(Integer l: adj.get(temp)){
                indegree[l]--;
                if(indegree[l]==0){
                    q.add(l);
                }
            }
        }
        System.out.println("courses = "+courses);

        return courses==numCourses ? ans : new int[0];

    }
}
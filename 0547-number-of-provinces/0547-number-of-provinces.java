class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0;i<n;i++){
            size[i] = 1;
        }
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
    }

    public int findParent(int s){
        if(s == parent[s]){
            return s;
        }

        parent[s] = findParent(parent[s]);

        return parent[s];
    }

    public void unionBySize(int u, int v){
        int u_fup = findParent(u);
        int v_fup = findParent(v);

        if(u_fup == v_fup){
            return;
        }

        if(size[u_fup] > size[v_fup]){
            parent[v_fup] = u_fup;
            size[u_fup] = size[u_fup]+size[v_fup];
        }else{
            parent[u_fup] = v_fup;
            size[v_fup] = size[u_fup]+size[v_fup];
        }
    }

    public boolean isConnectedComponent(int u, int v){
        return findParent(u) == findParent(v);
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        System.out.println("n = "+n);
        for(int i=0;i<n;i++){
            System.out.print("source = "+i+" : " );
            for(int j=0;j<n;j++){
                if(isConnected[i][j] ==1){
                    System.out.print(j+" " );
                }
            }
            System.out.println();
        } 

        DSU dsu = new DSU(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(  isConnected[i][j]!=0){
                    if(!dsu.isConnectedComponent(i,j)){
                        dsu.unionBySize(i,j);
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            dsu.findParent(i);
        }

        int count =0;
        for(int i=0;i<n;i++){
            System.out.println("i = "+i+",parent = "+dsu.parent[i]+",size = "+dsu.size[dsu.parent[i]]);
            if(i == dsu.parent[i]){
                count++;
            }
        }

        return count;
    }
}
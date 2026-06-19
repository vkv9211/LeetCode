class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> temp ;
        for(int i=0;i<=rowIndex;i++){
            temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(ans.get(j-1)+ ans.get(j));
                }
            }
            ans = temp;
           // System.out.println("i = "+i);
           // print(ans);
        }
       return ans;
    }

    public void print(List<Integer> ans){
        for(Integer i : ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
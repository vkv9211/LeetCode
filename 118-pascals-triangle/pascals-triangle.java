import java.util.*;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        // ans.add(Arrays.asList(1));
        // if(numRows ==1){
        //     return ans;
        // }
        //ans.add(Arrays.asList(1,1));

        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }

        //System.out.println("numRows = "+numRows+" size = "+ans.size());

        return ans;
    }
}
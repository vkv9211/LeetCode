import java.util.*;

class Solution {

    List<List<Integer>> pascalTri ;

    public Solution(){
        pascalTri = new ArrayList<>();
        pascalTri.add(Arrays.asList(1));
        pascalTri.add(Arrays.asList(1,1));

        for(int i=2;i<31;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(pascalTri.get(i-1).get(j-1)+pascalTri.get(i-1).get(j));
            }
            temp.add(1);
            pascalTri.add(temp);
        }

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            ans.add(pascalTri.get(i));
        }

        return ans;
    }
}
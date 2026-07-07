class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        // if(n == 1){
        //     return new ArrayList<>().add("()");
        // }
        Set<String> set  = new HashSet<>();

        util("", 0, 0, n, set);

        return new ArrayList<>(set);
    }

    public void util(String sb, int start, int end, int n, Set<String> set){
       // System.out.println("starting sb = "+sb);
        if(start == n && end == n){
          //  System.out.println("sb = "+sb);
            set.add(sb);
        }
        if(start > n || end > n || end > start){
            return ;
        }
        util(sb+"(", start+1, end, n, set);
        util(sb+")", start, end+1, n, set);
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        // if(n == 1){
        //     return new ArrayList<>().add("()");
        // }
        List<String> set  = new ArrayList<>();

        util(new StringBuilder(), 0, 0, n, set);

        return new ArrayList<>(set);
    }

    public void util(StringBuilder sb, int start, int end, int n, List<String> set){
       // System.out.println("starting sb = "+sb);
        if(start == n && end == n){
          //  System.out.println("sb = "+sb);
            set.add(sb.toString());
        }
        
        if(start < n){
            sb.append("(");
            util(sb, start+1, end, n, set);
            sb.deleteCharAt(sb.length()-1);
        }
        if(end < start){
            sb.append(")");
            util(sb, start, end+1, n, set);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
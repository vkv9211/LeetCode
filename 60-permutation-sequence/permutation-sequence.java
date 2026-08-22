class Solution {
    public String getPermutation(int n, int k) {

        List<String> ans = new ArrayList<>();

        char[] ch = new char[n];
        

        for(int i =1;i<=n;i++){
            ch[i-1] = (char)(i+'0'); 
        }

        util(0,n,ch,new StringBuilder(),ans);

        Collections.sort(ans);
       // System.out.println("n = "+n+", k = "+k);
       // System.out.println(ans);

        return ans.get(k-1);
        
    }

    public void util(int k, int n, char[] ch, StringBuilder sb, List<String> ans){

      //  System.out.println("****************");
      //  System.out.println("k = "+k+", sb = "+sb.toString());

        if(k >= n){
          //  System.out.println(new String(sb.toString()));
            ans.add(new String(sb.toString()));
            return;
        }

        for(int i = k;i<n;i++){
            swap(k,i,ch);
            sb.append(ch[k]);
            util(k+1,n, ch, sb, ans);
           // System.out.println("k = "+k+", i  = "+i);
            sb.deleteCharAt(sb.length()-1);
            swap(i, k, ch);
        }
    }

    public void swap(int i, int j, char[] ch){
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
    }
}
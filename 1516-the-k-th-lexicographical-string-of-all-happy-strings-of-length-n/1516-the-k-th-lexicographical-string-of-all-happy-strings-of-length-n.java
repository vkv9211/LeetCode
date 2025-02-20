class Solution {
    public String getHappyString(int n, int k) {
        char[] arr = {'a','b','c'};

        List<String> storeList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            sb.append("_");
        }
    
        for(int i =0;i<arr.length;i++){
            sb.setCharAt(0, arr[i]);
            getHappyStringUtil(sb,1,n,arr,storeList);
            if(sb.length() > 0){
                sb.setCharAt(sb.length()-1,'_');
            }
        }

        return storeList.size() >= k ? storeList.get(k-1) : "";
    }

    private static void getHappyStringUtil(StringBuilder sb,int start, int end, char[] arr,        List<String> storeList){
        
      //  System.out.println("start = "+start+", end = "+end);
        if(start > end){
           // System.out.println("base condition");
            return ;
        }
        if(start == end){
          //  System.out.println("True condition sb = "+sb.toString());
            storeList.add(sb.toString());
            return;
        }
        
        for(int i =0;i<arr.length;i++){
          //  System.out.println("start = "+start+", arr[i] = "+arr[i]+", sb = "+sb.toString());
            char ch = start>0 ? sb.charAt(start-1) : '_';
            
            if(ch != arr[i]){
              //  System.out.println("Inside if block start = "+start);
                sb.setCharAt(start, arr[i]);
                getHappyStringUtil(sb,start+1,end,arr,storeList);
                if(sb.length() > 0){
                    sb.setCharAt(sb.length()-1,'_');
                }
            }
        }
    }
}
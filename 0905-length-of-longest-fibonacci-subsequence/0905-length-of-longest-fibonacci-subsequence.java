class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        if(len <=2){
           // System.out.println("Initail break up 0");
            return 0;
        }
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        int temp_len = 0;
        int global_len= Integer.MIN_VALUE;

        for(int i =0;i<len;i++){
            temp_len =0;
            for(int j = i+1;j<len;j++){
                int first  = arr[i];
                int second = arr[j];
                int temp = first+second;
                temp_len = 2;
              //  System.out.println("Inside for Loop : first = "+first+", second = "+second+", temp = "+temp);
                while(set.contains(temp)){
                    first = second;
                    second = temp;
                    temp = first+second;
                    temp_len++;
                 //   System.out.println("Inside while Loop : first = "+first+", second = "+second+", temp = "+temp+", temp_len = "+temp_len);
                    global_len = Math.max(temp_len, global_len);
                }

                
            }
        }

       // System.out.println(global_len);

       return global_len == Integer.MIN_VALUE ? 0: global_len;
    }
}
class Solution {
    public int minMovesToMakePalindrome(String s) {
        int moves=0;
        int len = s.length();
        char[] arr = s.toCharArray();
        int i=0,j=len-1;
        boolean match;
        while(i<j){
          //System.out.println("Ist while loop i = "+i+", j = "+j);
          match = false;
          int k = j;
          while(k>i){
            // System.out.println("2nd while loop i = "+i+", k = "+k);
            if(arr[i] == arr[k]){
              int start = k;
              while(start<j){
                char ch = arr[start];
                arr[start] =  arr[start+1];
                arr[start+1] = ch;
                start++;
                moves++;
                match = true;
              }
              j--;
              break;
             // s = sb.toString();
            }
            k--;
            
          }
          if(k==i && !match){
             // System.out.println("moves = "+moves+", match ="+match);
            moves += (len-1)/2 - i;
          }
          i++;
          
        }
       // System.out.println(moves);
        return moves;
    }
}
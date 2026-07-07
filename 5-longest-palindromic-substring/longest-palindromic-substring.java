class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len ==0){
            return "";
        }
        if(len == 1){
            return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        for(int i =0;i<len-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                left = i;
                right = i+1;
            }
        }

        for(int diff=2;diff<len;diff++){
            for(int i=0;i<len-diff;i++){
                int j = i+diff;
                if(s.charAt(i) == s.charAt(j) && (dp[i+1][j-1])){
                    dp[i][j] = true;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right+1);
    }

//     public String util(int start, int end , String s){
//         if(end < start){
//             return "";
//         }

//         if(start == end){
//             return String.valueOf(s.charAt(start));
//         }
//         StringBuilder equal = new StringBuilder();
//         StringBuilder notEqual = new StringBuilder();

//         if(s.charAt(start) == s.charAt(end)){
//             String str = util(start+1, end-1, s);
//             if(str.length() == (end-(start+1))){
//                 equal = equal.append(s.charAt(start)).append(s.substring(start+1, end)).append(s.charAt(end));
//             }
//         }
//         String left  = util(start+1, end, s);
//         String right = util(start, end-1, s);

//         notEqual = left.length() > right.length() ? notEqual.append(left) : notEqual.append(right);
        
//         return equal.length() > notEqual.length() ? equal.toString() : notEqual.toString();
//     }
 }
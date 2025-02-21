class Solution {
    public boolean validPalindrome(String ss) {
        int left = 0;
        int right = ss.length()-1;
        while(left < right){
            if(ss.charAt(left) != ss.charAt(right)){
                return isPalindromeUtil(ss, left+1, right) || isPalindromeUtil(ss, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindromeUtil(String s, int left, int right){
      while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
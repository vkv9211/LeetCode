class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int sStart = 0;
        int tStart = 0;

        while(sStart<sLen && tStart<tLen){
            if(s.charAt(sStart)==t.charAt(tStart)){
                sStart++;
            }
            tStart++;
        }

        return sStart == sLen;
    }

    // public boolean isSubsequenceUtil(String s, int sLen, String t, int tLen){
    //     System.out.println("sLen = "+sLen+",tLen = "+tLen);
    //     if(sLen <0){
    //         return true;
    //     }
    //     if(tLen <0){
    //         return false;
    //     }

    //     boolean match = false;
    //     boolean noMatch = false;

    //     if(s.charAt(sLen) == t.charAt(tLen)){
    //         match = isSubsequenceUtil(s, sLen-1, t, tLen-1);
    //     }else{
    //         noMatch = isSubsequenceUtil(s, sLen, t, tLen-1);
    //     }

    //     return match || noMatch;
    // }
}
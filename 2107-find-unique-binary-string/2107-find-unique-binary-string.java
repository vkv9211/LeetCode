class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : nums[0].toCharArray()){
            sb.append('_');
        }

        String result ="";

        result = utilFunc(result,sb,0,nums[0].length(), nums, set);

        return result;
    }

    private String utilFunc(String result, StringBuilder sb,int start, int end, String[] nums, Set<String> set){
        if(start > end){
            return result;
        }
        if(result != ""){
            return result;
        }

        if(start == end){
            if(!set.contains(sb.toString())){
                result = sb.toString();
            }else{
                sb.setCharAt(sb.length()-1,'_');
            }
            return result;
        }

        sb.setCharAt(start, '0');
        result = utilFunc(result, sb, start+1, end, nums,set);
        if(result != ""){
            return result;
        }
        sb.setCharAt(start, '1');
        result = utilFunc(result, sb, start+1, end, nums,set);

        return result;
    }
}
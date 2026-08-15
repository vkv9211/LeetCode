class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> set = new ArrayList<>();

        for(int i=0;i<len;i++){
           // System.out.println("Starting in main function with "+nums[i]);
            set.add(nums[i]);
            util(len,nums,set,ans);
            set.remove(set.size()-1);
        }

        return ans;
    }

    public void util(int len, int[] nums, List<Integer> set, List<List<Integer>> ans){
        if(set.size() == len){
          //  System.out.println("Printing list");
          //  System.out.println(set);
            ans.add(new ArrayList<>(set));
        }

        for(int i=0;i<len;i++){
            if(!set.contains(nums[i])){
              //  System.out.println("nums[i]  = "+nums[i]);
                set.add(nums[i]);
                util(len,nums,set,ans);
                set.remove(set.size()-1);
            }
        }
    }


}
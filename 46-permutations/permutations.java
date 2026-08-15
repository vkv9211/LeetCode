class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        // for(int i=0;i<len;i++){
        //    // System.out.println("Starting in main function with "+nums[i]);
        //     set.add(nums[i]);
        //     util(len,nums,set,ans);
        //     set.remove(set.size()-1);
        // }

        int start =0;
        for(int i=0;i<len;i++){
        
            swap(start, i, nums);
            list.add(nums[start]);
            Util2(start+1,len,nums,list,ans);
            list.remove(list.size()-1);
            swap(i, start, nums);
        }

        return ans;
    }

    public void Util2(int start,int len, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == len){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i= start;i<len;i++){
            swap(start, i, nums);
            list.add(nums[start]);
            Util2(start+1, len, nums, list, ans);
            list.remove(list.size()-1);
            swap(i, start, nums);
        }
    }

    public void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // public void util(int len, int[] nums, List<Integer> set, List<List<Integer>> ans){
    //     if(set.size() == len){
    //       //  System.out.println("Printing list");
    //       //  System.out.println(set);
    //         ans.add(new ArrayList<>(set));
    //     }

    //     for(int i=0;i<len;i++){
    //         if(!set.contains(nums[i])){
    //           //  System.out.println("nums[i]  = "+nums[i]);
    //             set.add(nums[i]);
    //             util(len,nums,set,ans);
    //             set.remove(set.size()-1);
    //         }
    //     }
    // }


}
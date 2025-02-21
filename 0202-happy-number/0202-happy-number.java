class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = calculate(slow);           // Move slow pointer one step
            fast = calculate(calculate(fast)); // Move fast pointer two steps
        } while (slow != fast);              // Detect cycle

        return slow == 1; 
    }

    public static int calculate(int n){
      int sum = 0;
      int temp =0;
      while(n>0){
        temp = n%10;
        sum += temp*temp ;
        n = n/10;
      }
      
      return sum;
    }
}
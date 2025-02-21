class Solution {
    public boolean isHappy(int n) {
        if(n == 1){
          return true;
        }
        int slow = calculate(n);
        int fast = calculate(slow);
        int temp=0;
        while(fast !=10 && fast != 100){
          slow = calculate(slow);
          temp = calculate(fast);
          if(temp ==1 || temp ==10 || temp == 100){
            break;
          }
          fast  = calculate(temp);
          if(slow == fast){
            return false;
          }
        }
        return true;
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
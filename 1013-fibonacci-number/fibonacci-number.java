class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        int number = 0;

        int count = 0;
        while(count < n){
            
            if(count == 1){
                second = 1;
                number = second;
            }else{
                number = first +second;
                first = second;
                second = number;
            }
            count++;
        }

        return number;
    }
}
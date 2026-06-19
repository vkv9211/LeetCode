import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[]maxEleRight = new int[len];
        findMaxElement(len,prices,maxEleRight);

        int max = Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            max = Math.max(max, (maxEleRight[i]-prices[i]));
        }

        return max;
    }

    public void findMaxElement(int len, int[] prices, int[] maxEleRight){
        
        maxEleRight[len-1] = prices[len-1];

        Stack<Integer> s = new Stack<>();
        System.out.println("len = "+len);
        s.push(prices[len-1]);
        for(int i=len-2;i>=0;i--){
           // System.out.println("i = "+i+",i+1 = "+(i+1));
            if(prices[i] > s.peek()){
                s.push(prices[i]);
            }

            maxEleRight[i] = s.peek();
           // System.out.println("i = "+i+", max = "+maxEleRight[i]);
        }
    }
}
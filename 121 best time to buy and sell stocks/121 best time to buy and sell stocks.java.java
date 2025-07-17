// Leetcode link:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//1st Approach:-
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for( int price : prices){
            if(price < min)
            min = price;

            maxProfit = Math.max(maxProfit, price-min);
        }
        return maxProfit;
    }
}
// ------------------------------------------------------------------------------------------------------------------------



 //2nd Approach:- 
 class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = 0;
        int sell = 1;
        int profit = 0;
        
        for (int i=1; i<prices.length; i++){
            
            profit = Math.max(profit, prices[sell]-prices[buy]);
            
            if (prices[sell] < prices[buy]){
                buy = sell;
            }
            sell++;
        }
        
        return profit;
    }
}
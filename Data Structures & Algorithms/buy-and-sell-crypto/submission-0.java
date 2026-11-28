class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int maxProfit=0;
        for(int sell=1;sell<prices.length;sell++){
            if(prices[sell]>=prices[buy]){
                int profit=prices[sell]-prices[buy];
                maxProfit=Math.max(profit,maxProfit);
            }else{
                buy=sell;
            }
        }
        return maxProfit;
    }
}
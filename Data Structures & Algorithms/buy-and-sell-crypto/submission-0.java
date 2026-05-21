class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        int max = 0;

        //initial brute force solution
        for(int i = 0; i < prices.length; i++) {
            start = i;
            for(int n = i+1; n < prices.length; n++) {
                end = n;
                if(prices[start] < prices[end]) {
                    int result = prices[end]-prices[start];
                    if(result > max)
                        max = result;
                }
            }
        }

        return max;
    }
}

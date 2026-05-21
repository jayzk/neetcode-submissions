class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        int max = 0;

        while(end < prices.length) {
            if(prices[start] < prices[end]) { //if a profit can be made, check for a potential new max
                int result = prices[end]-prices[start];
                    if(result > max)
                        max = result;
                end++;
            } else { //if not, we found a new min price. Start buying from here
                start = end;
                end++;
            }
        }

        return max;
    }
}

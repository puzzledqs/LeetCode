public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null) return 0;
		if (prices.length == 0) return 0;
		int[] maxProfitBefore = new int[prices.length];
		int[] maxProfitAfter = new int[prices.length];
		
		int minbefore = prices[0];
		int maxafter = prices[prices.length-1];
		
		for (int i = 1; i < prices.length; i++) {
			int j = prices.length - 1 - i;
			minbefore = minbefore < prices[i] ? minbefore : prices[i];
			int gap1 = prices[i] - minbefore;
			maxProfitBefore[i] = maxProfitBefore[i-1] > gap1 ? maxProfitBefore[i-1] : gap1;
			
			maxafter = maxafter > prices[j] ? maxafter : prices[j];
			int gap2 = maxafter - prices[j];
			maxProfitAfter[j] = maxProfitAfter[j+1] > gap2 ? maxProfitAfter[j+1] : gap2;
		}
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			int sum = maxProfitBefore[i] + maxProfitAfter[i];
			profit = profit > sum ? profit : sum;
		}
		return profit;
	}
}
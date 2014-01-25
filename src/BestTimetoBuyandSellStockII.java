public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null) return 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int delta = prices[i] - prices[i-1];
			profit += delta > 0 ? delta : 0;
		}
		return profit;
	}
}
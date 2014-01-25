public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null) return 0;

		int minTillNow = prices[0];
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			minTillNow = minTillNow < prices[i] ? minTillNow : prices[i];
			int gap = prices[i] - minTillNow;
			profit = gap > profit ? gap : profit;
		}
		return profit;
	}
}
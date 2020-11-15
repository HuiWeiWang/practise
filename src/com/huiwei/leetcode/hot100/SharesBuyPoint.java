package com.huiwei.leetcode.hot100;

/**(1)给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 思路：
 * 记录【今天之前买入的最小值】
 * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
 * 比较【每天的最大获利】，取最大值即可
 *
 *(2)（含冷冻期的股票交易）
 * 给定一个整数数组，其中第?i?个元素代表了第?i?天的股票价格 。?
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class SharesBuyPoint {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4,8}));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length ; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public static int maxProfitWithFrizePeroid(int[] prices) {
        if(prices.length<=1) return 0;
        return 0;
    }
}

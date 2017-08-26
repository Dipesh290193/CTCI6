package ch8_RecursionAndDyanamicProgramming;

import java.util.HashMap;

public class Coins {

	public static void main(String args[])
	{
		
		System.out.println(coins(10));
	}
	
	public static long coins(int money)
	{
		if(money < 0)
			return -1;
		int[] coins = {25,10,5,1};
		HashMap<String, Long> map = new HashMap<String, Long>();
		return coins(coins, money, 0, map);
	}
	
	public static long coins(int[] coins, int money, int index, HashMap<String, Long> map)
	{
		if(money == 0)
			return 1;
		if(index >= coins.length)
			return 0;
		String key = money+ "-" +index;
		if(map.containsKey(key))
		{
			return map.get(key);
		}
		int coinAmount = 0;
		long ways = 0;
		while(coinAmount <= money)
		{
			int remaining = money - coinAmount;
			ways+= coins(coins,remaining, index+1, map);
			coinAmount+= coins[index];
		}
		map.put(key, ways);
		return ways;
	}
	
	public static int makeChange(int n)
	{
		int[] denoms = {25,10, 5, 1};
		int[][] map= new int[n+1][denoms.length];
		return makeChange(n,denoms, 0, map);
	}
	public static int makeChange(int n, int[] denoms, int index, int[][] map)
	{
		if(map[n][index] > 0)
			return map[n][index];
		if(index >= denoms.length -1)
			return 1;
		int ways = 0;
		int denomAmount = denoms[index];
		for(int i =0 ; i*denomAmount <= n ;i++)
		{
			int amountremaning = n - i * denomAmount;
			ways+=makeChange(amountremaning,denoms,index+1, map);
		}
		map[n][index] = ways;
		return ways;
	}
}

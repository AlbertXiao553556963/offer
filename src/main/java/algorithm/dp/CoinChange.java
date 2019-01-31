package algorithm.dp;


import java.util.*;

/**
 * 动态规划-硬币找零
 */
public class CoinChange {

	// 硬币面值预先已经按降序排列
	static int[] coinValue = new int[] { 50, 20, 11, 5, 2,1 };


	/**  
	 * @param money  需要找零的面值
	 */ 
	public static void changeCoins(int money) {

	    Map<Integer, List<Integer>> result = new HashMap<>();

		int[] coinsUsed = new int[money + 1];  	 // 保存面值为i的纸币找零所需的最小硬币数

		for(int i = 1 ; i <= money; i++) {
			for(int j = 0; j < coinValue.length; j++) {
				if(i >= coinValue[j]) {
					int temp =  coinsUsed[i - coinValue[j]] + 1;
					if(coinsUsed[i] == 0 || temp < coinsUsed[i]) {
						coinsUsed[i] = temp;
						if(result.get(i) == null) {
						    result.put(i, new ArrayList<>());
                        }
                        List list = result.get(i);
						if(i > coinValue[j]) list.addAll(result.get(i - coinValue[j]));
                        list.add(coinValue[j]);
					}
				}
			}
		}

		System.out.println("找零" + money +  "需要硬币个数:" + coinsUsed[money]);
		System.out.println("找零个数:" + result.get(money));
	}
 
	public static void main(String[] args) {  

		// 需要找零的面值
		while (true) {
			System.out.println("请输入需要找零的面值:");
			Scanner in = new Scanner(System.in);
			int money = Integer.valueOf(in.nextLine());
			// 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
			changeCoins(money);
		}
	}
 
}

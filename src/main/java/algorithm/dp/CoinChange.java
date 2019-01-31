package algorithm.dp;


import java.util.*;

/**
 * ��̬�滮-Ӳ������
 */
public class CoinChange {

	// Ӳ����ֵԤ���Ѿ�����������
	static int[] coinValue = new int[] { 50, 20, 11, 5, 2,1 };


	/**  
	 * @param money  ��Ҫ�������ֵ
	 */ 
	public static void changeCoins(int money) {

	    Map<Integer, List<Integer>> result = new HashMap<>();

		int[] coinsUsed = new int[money + 1];  	 // ������ֵΪi��ֽ�������������СӲ����

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

		System.out.println("����" + money +  "��ҪӲ�Ҹ���:" + coinsUsed[money]);
		System.out.println("�������:" + result.get(money));
	}
 
	public static void main(String[] args) {  

		// ��Ҫ�������ֵ
		while (true) {
			System.out.println("��������Ҫ�������ֵ:");
			Scanner in = new Scanner(System.in);
			int money = Integer.valueOf(in.nextLine());
			// ����ÿһ����ֵ�����������СӲ������0�ŵ�Ԫ�������ã�����Ҫ���1
			changeCoins(money);
		}
	}
 
}

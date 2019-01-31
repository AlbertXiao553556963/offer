package algorithm.recursive;

import java.util.ArrayList;

public class Lesson5_1 {
	
	public static long[] rewards = {1, 2, 5, 10};	// ��������ֽ��
	
	/**
    * @Description:	ʹ�ú����ĵݹ飨Ƕ�ף����ã��ҳ����п��ܵĽ������
    * @param totalReward- �����ܽ�result- ���浱ǰ�Ľ�
    * @return void
    */
	
    public static void get(long totalReward, ArrayList<Long> result) {
    	
    	// �� totalReward = 0 ʱ��֤���������������Ľ⣬����Ƕ�׵��ã������
    	if (totalReward == 0) {
    		System.out.println(result);
    	 return;
     }
    	// �� totalReward < 0 ʱ��֤�����������������Ľ⣬�����
    	else if (totalReward < 0) {
    		return;
    	} else {
    		for (int i = 0; i < rewards.length; i++) {
    			ArrayList<Long> newResult = (ArrayList<Long>)(result.clone());	// ������ 4 ���������Ҫ clone ��ǰ�ĽⲢ���뱻���õĺ���
    			newResult.add(rewards[i]);						// ��¼��ǰ��ѡ�񣬽��һ������
    			get(totalReward - rewards[i], newResult);		// ʣ�µ����⣬����Ƕ�׵���ȥ���
    		}
    	}
    	
    }

}

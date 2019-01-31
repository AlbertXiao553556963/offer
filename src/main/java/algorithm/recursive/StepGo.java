package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: XiaoMingxuan
 * @email: mingxuan.xmx@alibaba-inc.com
 * @create: 2018-12-20 23:00
 * 使用迭代法解决上台阶问题
 **/
public class StepGo {

    private static int[] stepNum = {1,2};

    public static int loop(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int preStep1 = 2;
        int preStep2 = 1;
        int sum = 0;
        for(int i = 3; i <= n; i++) {
            sum = preStep1 + preStep2;
            preStep2 = preStep1;
            preStep1 = sum;
        }
        return sum;
    }

    public static int recursive(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return recursive(n -1 ) + recursive(n - 2);
    }

    public static void getResult(int n, List<Integer> list) {

        if(n < 0) return;

        if(n == 0) {
            System.out.println(list);
            return;
        }

        for(int i = 0; i < stepNum.length; i++) {
            List newList = list.stream().collect(Collectors.toList());
            newList.add(stepNum[i]);
            getResult(n -  stepNum[i], newList);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(n + " step has " + recursive(n) + " strategy");
        System.out.println(n + " step has " + loop(n) + " strategy");
        //print node
        getResult(n, new ArrayList());
    }
}

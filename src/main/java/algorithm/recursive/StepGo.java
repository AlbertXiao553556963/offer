package algorithm.recursive;

/**
 * @author: XiaoMingxuan
 * @email: mingxuan.xmx@alibaba-inc.com
 * @create: 2018-12-20 23:00
 * 上台阶问题
 **/
public class StepGo {

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

    public static void main(String[] args) {
        int n = 4;
        System.out.println(n + "阶台阶走法，使用递归计算" + recursive(n));
        System.out.println(n + "阶台阶走法，使用循环计算" + loop(n));
    }
}

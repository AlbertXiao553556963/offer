package algorithm.iteration;

/**
 * 计算平方根
 *
 * @author: XiaoMingxuan
 * @email: mingxuan.xmx@alibaba-inc.com
 * @create: 2019-01-14 11:32
 **/
public class SquareRoot {

    public static double getSquareRoot(double num, double deltaThreshold) {
        if (num <= 0) {
            throw new RuntimeException("negative does not have square root");
        }
        double deltaThresholdNow = num;
        double min = 0;
        double max = num;
        double result = (max + min) / 2;
        while (deltaThresholdNow > deltaThreshold) {
            if ((result * result - num) > 0) {
                max = result;
            } else {
                min = result;
            }
            result = (max + min) / 2;
            deltaThresholdNow = Math.abs(result * result - num);
        }
        return result;
    }


    public static double getSqureRoot(int num, double deltaThreshold, int maxTry) {

        if (num <= 1) {
            return -1.0;
        }

        double min = 1.0;
        double max = (double) num;

        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / num) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > num) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }

        return -2.0;

    }


    public static void main(String[] args) {

        int number = 128;
        double squareRoot = getSqureRoot(number, 0.1, 10000);
        System.out.println(squareRoot);
        squareRoot = getSquareRoot(number, 0.0001);
        System.out.println(squareRoot);

    }

}

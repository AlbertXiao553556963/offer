package jianzhi;

/**
 * 二维有序数组查找给定的数字
 * @author: XiaoMingxuan
 * @email: mingxuan.xmx@alibaba-inc.com
 * @create: 2018-11-29 09:17
 **/
public class Question1 {

    private static boolean find(int[][] array, int num) {
        if(array == null) return false;

        int row = 0;
        int line =  array[0].length - 1;
        while (line >=0 && row < array.length) {
            if(array[row][line] == num) {
                return true;
            } else if (array[row][line] > num) {
                line--;
            } else if (array[row][line] < num) {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        /**
         * 数组第二种初始化方式，
         */
//        int[][] array = new int[3][4];
//        int[][] array = new int[3][];
        System.out.println(find(array, 12));
        System.out.println(find(array, -12));
        System.out.println(find(new int[][]{{1,2,3}}, 1));
        System.out.println(find(new int[][]{{1},{2},{3}}, 1));
    }
}

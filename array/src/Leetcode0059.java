public class Leetcode0059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int j = 0;
        int num = 1;
        while (num <= n * n) {
//            往右走
            while (j < n && res[i][j] == 0) {
                res[i][j] = num;
                num++;
                j++;
            }
            j--;
            i++;
//            往下走
            while (i < n && res[i][j] == 0) {
                res[i][j] = num;
                num++;
                i++;
            }
            i--;
            j--;
//            往左走
            while (j >= 0 && res[i][j] == 0) {
                res[i][j] = num;
                num++;
                j--;
            }
            j++;
            i--;
//            往上走
            while (i >= 0 && res[i][j] == 0) {
                res[i][j] = num;
                num++;
                i--;
            }
            i++;
            j++;

        }
        return res;
    }
}

public class Leetcode0048 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int j = 0; j< len/2; j++){
            for (int i = 0; i<len; i++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = t;
            }
        }
    }

    //  n是要旋转第几层
//    public void rotate_onelayer(int[][] matrix, int n) {
//        int len = matrix.length;
//        if (len / 2 <= n)
//            return;
//        for (int i = n; n<len-n-1; i++){
//            int t = matrix[n][i];
//            matrix[n][i] = matrix
//            matrix[i][len-n-1] = matrix[n][i];
//            matrix
//        }
//    }

    public static void main(String[] args) {
        System.out.println(5 / 2.);
    }
}

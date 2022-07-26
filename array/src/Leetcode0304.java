import java.util.Arrays;

public class Leetcode0304 {

    private int sums[][];

    public Leetcode0304(int[][] matrix) {
        int rows = matrix.length+1;
        int lines = matrix[0].length+1;
        sums = new int[rows][lines];
        for (int[] sum : sums) {
            Arrays.fill(sum, 0);
        }
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < lines-1; j++) {
                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sums[row2+1][col2+1] - sums[row1 - 1 + 1][col2+1] - sums[row2+1][col1 - 1 +1] + sums[row1+1 - 1][col1+1 - 1];
    }


    public void Leetcode03041(int[][] matrix) {
        int rows = matrix.length;
        int lines = matrix[0].length;
        sums = new int[rows][lines];
        for (int[] sum : sums) {
            Arrays.fill(sum, 0);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
//                对第一行特殊处理
                if (i == 0) {
                    if (j == 0) {
                        sums[i][j] = matrix[i][j];
                    } else {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    }
                    continue;
                }
//                对第一列特殊处理
                if (j == 0) {
                    sums[i][j] = sums[i - 1][j] + matrix[i][j];
                    continue;
                }
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0){
            return sums[row2][col2];
        }
        if(row1==0){
            if(row2==0)
                return sums[0][col2] - sums[0][col1-1];
            else {
                return sums[row2][col2] - sums[row2][col1-1];
            }
        }
        if(col1==0){
            return sums[row2][col2] - sums[row1-1][col2];
        }


        return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Leetcode0304 leetcode0304 = new Leetcode0304(ints);
        System.out.println(leetcode0304.sumRegion(2,1,4,3));

//        int[][] ints = new int[][]{
//                {-4, -5},
//        };
//        Leetcode0304 leetcode0304 = new Leetcode0304(ints);
//        System.out.println(leetcode0304.sumRegion(0,1,0,1));
    }

}

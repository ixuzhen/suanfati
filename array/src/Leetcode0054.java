import java.util.ArrayList;
import java.util.List;

public class Leetcode0054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        String direction = "right";
        String right = "right";
        String left = "left";
        String up = "up";
        String down = "down";
        boolean continue_flag = true;
//        int[][] visited = new int[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int rows = matrix.length;
        int lines = matrix[0].length;
        int upper_bound = 0;
        int left_bound = 0;
        int bottem_bound = rows - 1;
        int right_bound = lines - 1;
        while (list.size()<rows*lines) {

            if(right.equals(direction)){
                while(j<=right_bound){
                    list.add(matrix[i][j]);
                    j++;
                }
                direction = down;
                j--;
                i++;
                upper_bound++;
            }else if(down.equals(direction)){
                while(i<=bottem_bound){
                    list.add(matrix[i][j]);
                    i++;
                }
                direction = left;
                i--;
                j--;
                right_bound--;
            }else if(left.equals(direction)){
                while(j>=0&&j>=left_bound){
                    list.add(matrix[i][j]);
                    j--;
                }
                direction = up;
                j++;
                i--;
                bottem_bound--;
            }else if(up.equals(direction)){
                while(i>=0&&i>=upper_bound){
                    list.add(matrix[i][j]);
                    i--;
                }
                direction = right;
                i++;
                j++;
                left_bound++;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        String direction = "right";
        String right = "right";
        String left = "left";
        String up = "up";
        String down = "down";
        boolean continue_flag = true;
        int[][] visited = new int[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        int rows = matrix.length;
        int lines = matrix[0].length;
        while (continue_flag) {
            if(visited[i][j]==1){
                break;
            }
            if(right.equals(direction)){
                while(i<rows && j<lines && i>=0 && j>=0 && visited[i][j]==0){
                    list.add(matrix[i][j]);
                    visited[i][j] = 1;
                    j++;
                }
                direction = down;
                j--;
                i++;
            }else if(down.equals(direction)){
                while(i<rows && j<lines&& i>=0 && j>=0 && visited[i][j]==0){
                    list.add(matrix[i][j]);
                    visited[i][j] = 1;
                    i++;
                }
                direction = left;
                i--;
                j--;
            }else if(left.equals(direction)){
                while(i<rows && j<lines&& i>=0 && j>=0 && visited[i][j]==0){
                    list.add(matrix[i][j]);
                    visited[i][j] = 1;
                    j--;
                }
                direction = up;
                j++;
                i--;
            }else if(up.equals(direction)){
                while(i<rows && j<lines&& i>=0 && j>=0 && visited[i][j]==0){
                    list.add(matrix[i][j]);
                    visited[i][j] = 1;
                    i--;
                }
                direction = right;
                i++;
                j++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] ints = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Leetcode0054 leetcode0054 = new Leetcode0054();
        List<Integer> integers = leetcode0054.spiralOrder(ints);
        System.out.println();
    }
}

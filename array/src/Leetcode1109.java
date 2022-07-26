public class Leetcode1109 {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                answer[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i] + answer[i-1];
        }
        return answer;
    }

    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                answer[i] += booking[2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] ints = {
            {1,2,10},
            {2,3,20},
            {2,5,25}
        };
        Leetcode1109 leetcode1109 = new Leetcode1109();
        leetcode1109.corpFlightBookings(ints, 5);
    }

}

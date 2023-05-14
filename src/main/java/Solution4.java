import java.util.*;

public class Solution4 {
    public static void main(String[] args) throws Exception {
        //case1
//        int k = 4;
//        int m = 3;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}; //12
        // 33

        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        // 8

        System.out.println("Solution4.main : " + solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        for (int i = score.length - 1; i >= 0; i--) {
            if((score.length - i) % m == 0){
                answer += score[i] * m;
            }
        }

        return answer;
    }

}

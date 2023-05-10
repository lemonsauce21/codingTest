import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        // 기대값 [19, 15, 6]

        Integer[] result = solution(name, yearning, photo);

        for (Integer i : result) {
            System.out.println("i = " + i);
        }
        
    }

    public static Integer[] solution(String[] name, int[] yearning, String[][] photo) throws Exception {
        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> info = new HashMap<>();

        if (name.length != yearning.length) {
            throw new Exception("Data is not correct");
        }

        for (int i = 0; i < name.length; i++) {
            info.put(name[i], yearning[i]);
        }

        for (String[] thisPhoto : photo) {
            Integer score = 0;
            for (String person : thisPhoto) {
                Integer tmpScore = info.get(person);
                if (tmpScore == null) {
                    tmpScore = 0;
                }

                score += tmpScore;
            }
            resultList.add(score);
        }
        
        return resultList.toArray(new Integer[resultList.size()]);
    }

}

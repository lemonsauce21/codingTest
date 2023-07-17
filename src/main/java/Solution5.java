import java.util.*;

public class Solution5 {
    public static void main(String[] args) throws Exception {
        /*
            문제 : 문자열 작성할 때 최소 몇 번 눌러야 작성할 수 있는지?
            키 : 1 ~ 100 개, 문자 무작위
            문자열 작성 불가 : -1
        */

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};

        int[] result = solution(keymap, targets);
        int[] result2 = solution2(keymap, targets);

        for (int i : result2) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        //키 인포 세팅 : map
        //map : A, 2 - 문자, 횟수
        Map<Character, Integer> keyInfo = new HashMap<>();
        for (String key : keymap) {
            char[] keyCharArr = key.toCharArray();
            for (int i = 0; i < keyCharArr.length; i++) {
                if (keyInfo.get(keyCharArr[i]) == null || keyInfo.get(keyCharArr[i]) > (i + 1)) {
                    keyInfo.put(keyCharArr[i], i + 1);
                }
            }
        }

        /*for (char key : keyInfo.keySet()) {
            System.out.println(key + " = " + keyInfo.get(key));
        }*/

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            Integer cnt = 0;
            for (char thisChar : target.toCharArray()) {
                if (keyInfo.containsKey(thisChar)) {
                    cnt += keyInfo.get(thisChar);
                } else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    //속도개선 charAt
    public static int[] solution2(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        //키 인포 세팅 : map
        //map : A, 2 - 문자, 횟수
        Map<Character, Integer> keyInfo = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char thisChar = key.charAt(i);
                if (keyInfo.get(thisChar) == null || keyInfo.get(thisChar) > (i + 1)) {
                    keyInfo.put(thisChar, i + 1);
                }
            }
        }

        /*for (char key : keyInfo.keySet()) {
            System.out.println(key + " = " + keyInfo.get(key));
        }*/

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            Integer cnt = 0;

            for (int j = 0; j < target.length(); j++) {
                char thisChar = target.charAt(j);

                if (keyInfo.containsKey(thisChar)) {
                    cnt += keyInfo.get(thisChar);
                } else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

}

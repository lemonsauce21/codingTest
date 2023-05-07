import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        // 기대값 ["mumu", "kai", "mine", "soe", "poe"]

        solution(players, callings);
    }

    public static void solution(String[] players, String[] callings) {

        //Map Index
        Map<String, Integer> playerList = new HashMap<>();  //index search용 데이터

        IntStream.range(0, players.length).forEach(index -> {
            playerList.put(players[index], index);
        });

        for(String call : callings){
            int callPlayerIndex = playerList.get(call);

            playerList.put(call, callPlayerIndex - 1);
            playerList.put(players[callPlayerIndex -1], callPlayerIndex);

            players[callPlayerIndex] = players[callPlayerIndex -1];
            players[callPlayerIndex -1] = call;
        }

        /*
        //List index : 작동하지만 모데이터 클 경우 시간경과
        List<String> playerList = new ArrayList<>(List.of(players));

        for(String call : callings){
            int thisIndex = playerList.indexOf(call);

            playerList.add(thisIndex - 1, call);
            playerList.remove(thisIndex + 1);
        }

        String[] result = playerList.toArray(new String[playerList.size()]);
        */

        for(String r : players){
            System.out.print(" / " + r);
        }
    }

}

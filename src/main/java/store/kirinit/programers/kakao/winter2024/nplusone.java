package store.kirinit.programers.kakao.winter2024;

import java.util.*;

public class nplusone {

    public static void main(String[] args) {
        int coin = 4;
        int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        System.out.println(solution(coin, cards));
    }

    private static int solution(int coin, int[] cards) {
        int answer = 0;
        // 현재 라운드에서 가지고 올 수 있는 카드 중 가장 적은 비용으로 카드를 뽑아서 n+1을 만든다
        // 각 라운드에서 만들 수 있는 카드 index와 필요한 coin 수, 그리고 만들 수 있는 최소 round를 저장하는 배열 생성
        List<int[]> cardSet = new ArrayList<>(); // n+1을 만들 수 있는 카드 2개의 index, 필요한 coin 수, 해당 round 수
        // 한번 사용한 card는 사용하지 않도록 방문 배열 생성
        int n = cards.length;
        int goal = n + 1;
        boolean[] visited = new boolean[goal];
        int leftCoin = coin;
        int totalRound = answer = (n - n / 3) / 2 + 1;
        // cardSet를 만들기
        for (int i = 0; i < n; i++) {
            int cardIndex1 = i;
            int cardIndex2 = 0;
            for (int j = 0; j < n; j++) {
                if (cards[j] == goal - cards[cardIndex1] && !visited[j]) {
                    cardIndex2 = j;
                    int c = 0;
                    c += cardIndex1 >= n / 3 ? 1 : 0;
                    c += cardIndex2 >= n / 3 ? 1 : 0;

                    int round = cardIndex2 < n / 3 ? 1 : (cardIndex2 - n / 3) / 2 + 1;

                    cardSet.add(new int[] {cardIndex1, cardIndex2, c, round});
                    visited[cardIndex1] = true;
                    visited[cardIndex2] = true;
                    break;
                }
            }
        }
        for (int round = 1; round < totalRound; round++) {
            int currentRound = round;
            int finalLeftCoin = leftCoin;
            List<int[]> availableSets = cardSet.stream()
                .filter(s -> s[3] <= currentRound && s[2] <= finalLeftCoin)
                .sorted(Comparator.comparing(s -> s[2])).toList();
            if (availableSets.isEmpty()) {
                answer = currentRound;
                break;
            } else {
                int[] set = availableSets.stream().findFirst().get();
                leftCoin -= set[2];

                // 카드 사용
                cardSet = cardSet.stream().filter(c -> c[0] != set[0] && c[1] != set[1]).toList();
            }
        }
        return answer;
    }

}

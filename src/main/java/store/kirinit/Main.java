package store.kirinit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] points = {
            {3, 2}, {6, 4}, {4, 7}, {1, 4}
        };
        int[][] routes = {
            {4, 2}, {1, 3}, {4, 2}, {4, 3}
        };
        int out = solution(points, routes);
        System.out.printf("%d\n", out);
    }


    public static int solution(int[][] points, int[][] routes) {
        // 로봇 수 초기화
        int robots = routes.length;
        boolean[][] visited = new boolean[101][101];
        // 각 로봇의 현재 위치 초기화
        Queue<int[]> position = new LinkedList<>();
        // 충돌 위험 위치 저장
        HashSet<Integer> answer = new HashSet<>();
        for (int i = 0; i < robots; i++) {
            // 선택된 로봇 첫 위치
            int currentPoint = routes[i][0] - 1;
            int x = points[currentPoint][0];
            int y = points[currentPoint][1];
            int nextPoint = 1;
            position.add(new int[]{x, y, i, nextPoint});
            // 현재 위치 방문 기록
            if (visited[x][y]) {
                answer.add(getXYValue(x, y));
            }
            visited[x][y] = true;
        }
        // 매초 마다 각 로봇의 위치를 파악하고 중복이 되는지 확인
        while (!position.isEmpty()) {
            int[] robot = position.poll();
            int currentX = robot[0];
            int currentY = robot[1];
            int robotNumber = robot[2];
            int nextPoint = robot[3];
            int nextX = points[routes[robotNumber][nextPoint] - 1][0];
            int nextY = points[routes[robotNumber][nextPoint] - 1][1];
            // x, y 좌표가 다음 포인트에 도착하면 currentPoint 증가
            if (nextX == currentX && nextY == currentY) {
                if (max)
                if (routes[robotNumber][nextPoint])
                break;
            }
            // x 이동이 우선순위
            if (nextX > currentX) {
                currentX++;
                position.add(new int[]{currentX, currentY, robotPoint, nextX, nextY});
                continue;
            }
            if (nextX < currentX) {
                currentX--;
                road.get(i).add(getXYValue(currentX, currentY));
                continue;
            }
            // y 이동
            if (nextY > currentY) {
                currentY++;
                road.get(i).add(getXYValue(currentX, currentY));
                continue;
            }
            if (nextY < currentY) {
                currentY--;
                road.get(i).add(getXYValue(currentX, currentY));
            }
        }
        // 운송 경로에 따라 각 로봇이 매초마다 어떤 좌표에 있는지 저장
        for (int i = 0; i < x; i++) {
            // i + 1번째 로봇의 운송 경로를 모두 이동하여 저장
            int[] pointNumber = routes[i];
            int currentPoint = 0;
            int currentX = points[pointNumber[currentPoint] - 1][0];
            int currentY = points[pointNumber[currentPoint] - 1][1];
            road.get(i).add(getXYValue(currentX, currentY));
            // 포인트를 지나갈 때마다 currentPoint를 올리고 최종 포인트까지 도착하면 마무리
            while (currentPoint < pointNumber.length - 1) {
                // 다음 포인트 좌표
                int nextX = points[pointNumber[currentPoint + 1] - 1][0];
                int nextY = points[pointNumber[currentPoint + 1] - 1][1];
                // x, y 좌표가 다음 포인트에 도착하면 currentPoint 증가
                if (nextX == currentX && nextY == currentY) {
                    currentPoint++;
                    break;
                }
                // x 이동이 우선순위
                if (nextX > currentX) {
                    currentX++;
                    road.get(i).add(getXYValue(currentX, currentY));
                    continue;
                }
                if (nextX < currentX) {
                    currentX--;
                    road.get(i).add(getXYValue(currentX, currentY));
                    continue;
                }
                // y 이동
                if (nextY > currentY) {
                    currentY++;
                    road.get(i).add(getXYValue(currentX, currentY));
                    continue;
                }
                if (nextY < currentY) {
                    currentY--;
                    road.get(i).add(getXYValue(currentX, currentY));
                }
            }
        }
        return answer;
    }

    private static Integer getXYValue(int currentX, int currentY) {
        return 100 * (currentX - 1) + currentY;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        // 1. 타임라인 배열을 활용한 동시 최대 인원 산출
        int[] timeCount = new int[1321];
        for (int[] time : timetable) {
            for (int i = time[0]; i <= time[1]; i++) {
                timeCount[i]++;
            }
        }

        int maxPeople = 0;
        for (int count : timeCount) {
            maxPeople = Math.max(maxPeople, count);
        }

        // 2. 예외 처리: 혼자거나 겹치는 인원이 없으면 거리 조건이 필요 없음
        if (maxPeople <= 1) return 0;

        // 3. 가능한 최대 맨해튼 거리(2n - 2)부터 1까지 완전 탐색
        int maxDist = 2 * n - 2;
        for (int d = maxDist; d >= 1; d--) {
            // 거리 d로 maxPeople만큼 배치가 가능한지 검증
            if (canPlace(n, maxPeople, d)) {
                return d; // 위에서부터 내려왔으므로 처음 성공한 거리가 최댓값
            }
        }

        return 0;
    }

    private boolean canPlace(int n, int maxPeople, int d) {
        // 첫 번째 사람의 시작 위치를 모든 좌표에서 시도
        for (int startY = 0; startY < n; startY++) {
            for (int startX = 0; startX < n; startX++) {
                List<int[]> placed = new ArrayList<>();
                placed.add(new int[]{startY, startX});

                // 시작 위치 이후의 좌표부터 순차적으로 탐욕적(Greedy) 배치
                for (int i = startY; i < n; i++) {
                    int j = (i == startY) ? startX + 1 : 0;
                    for (; j < n; j++) {
                        boolean isSafe = true;
                        
                        // 기존에 배치된 모든 사람과의 맨해튼 거리 검증
                        for (int[] p : placed) {
                            int dist = Math.abs(p[0] - i) + Math.abs(p[1] - j);
                            if (dist < d) {
                                isSafe = false;
                                break;
                            }
                        }
                        
                        // 거리 조건(d 이상)을 만족하면 배치
                        if (isSafe) {
                            placed.add(new int[]{i, j});
                            if (placed.size() == maxPeople) return true;
                        }
                    }
                }
            }
        }
        return false; // 모든 시작점을 시도해도 배치가 불가능한 경우
    }
}
from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
board = []
visit = [[0] * n for _ in range(n)]
queue = [[0,0]]
dx = [1, 0]
dy = [0, 1]

for i in range(0, n, 1):
    board.append(list(map(int, input().split())))

while queue:
    x ,y = queue[0][0], queue[0][1]
    del queue[0]

    if board[x][y] == -1:
        print("HaruHaru")
        exit(0)

    jump = board[x][y]
    
    for i in range(2):
        nx = x + dx[i] * jump
        ny = y + dy[i] * jump

        if 0 <= nx < n and 0 <= ny < n and visit[nx][ny] == 0:
            visit[nx][ny] = 1
            queue.append([nx, ny])

print("Hing")
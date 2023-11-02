import sys
from collections import deque
input = lambda : sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**9)

dir_x = [0, 1, 0, -1]
dir_y = [1, 0, -1, 0]

def BFS(start_x, start_y):
    q = deque()
    q.append([start_x, start_y])
    while q:
        now_x, now_y = q.popleft()
        for num in range(4):
            nx = now_x + dir_x[num]
            ny = now_y + dir_y[num]
            if 0<=nx<N and 0<=ny<M and visit[nx][ny] == False and board[nx][ny] != 0:
                visit[nx][ny] = True
                q.append([nx, ny])
                board[nx][ny] = board[now_x][now_y] + 1
                


N, M = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]
visit = [[False] * (M) for _ in range(N)]
BFS(0, 0)
print(board[N-1][M-1])
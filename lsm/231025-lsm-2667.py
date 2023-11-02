import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

def show():
    for x in board:
        print(x)

def BFS(start_x, start_y):
    q = deque()
    visit[start_x][start_y] = True
    q.append((start_x, start_y))
    cnt = 0

    while q:
        x, y = q.popleft()
        cnt += 1
        for dir_x, dir_y in dir:
            nx = x + dir_x
            ny = y + dir_y
            if 0<=nx<N and 0<=ny<N and board[nx][ny] == '1' and visit[nx][ny] == False:
                visit[nx][ny] = True
                q.append((nx, ny))

    
    return cnt

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]

N = int(input())
board = [list(input()) for _ in range(N)]
visit = [[False] * (N) for _ in range(N)]
answer = list()

for x in range(N):
    for y in range(N):
        if board[x][y] == '1' and visit[x][y] == False:
            answer.append(BFS(x, y))

print(len(answer))
for value in sorted(answer):
    print(value)
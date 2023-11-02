import sys
from collections import deque
input = lambda : sys.stdin.readline().rstrip()

def BFS(start_x, start_y):
    cnt = 0
    q = deque()
    q.append((start_x, start_y, 0))
    answer[start_x][start_y] = cnt

    while q:
        now_x, now_y, cnt = q.popleft()
        for dir_x, dir_y in dir:
            nx = now_x + dir_x
            ny = now_y + dir_y

            if 0<=nx<n and 0<=ny<m and board[nx][ny] == 1 and answer[nx][ny] == 0:
                q.append((nx, ny, cnt+1))
                answer[nx][ny] = cnt+1

def post_processing():
    for i in range(n):
        for j in range(m):
            if answer[i][j] == 0 and board[i][j] == 1:
                answer[i][j] = -1

def show():
    for i in range(n):
        for j in range(m):
            print(answer[i][j], end=' ')
        print()
    

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
start_x, start_y = 0, 0
n, m = map(int, input().split())
board = [[0]*m for _ in range(n)]

for i in range(n):
    args = list(map(int, input().split()))
    for j in range(m):
        board[i][j] = args[j]
        if args[j] == 2:
            start_x = i
            start_y = j


# board = [list(map(int, input().split())) for _ in range(n)]
answer = [[0] * (m) for _ in range(n)]
BFS(start_x, start_y)
post_processing()
show()
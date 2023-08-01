import sys
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:    
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and data[nx][ny]==1:
                    queue.append((nx, ny))
                    visited[nx][ny] = True

n ,m = map(int, sys.stdin.readline().split(" "))
data = [list(map(int, sys.stdin.readline().rstrip().split(" "))) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dx = [1, 1, 1, -1, -1, -1, 0, 0]
dy = [1, -1, 0, 1, -1, 0, 1, -1]
cnt = 0

            

for i in range(n):
    for j in range(m):
        if not visited[i][j] and data[i][j] == 1:
            bfs(i, j)
            cnt +=1

print(cnt)
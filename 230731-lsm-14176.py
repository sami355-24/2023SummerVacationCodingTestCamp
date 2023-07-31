import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

dir = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
M, N = map(int, input().split())
ary = [[-1]*N for _ in range(M)]
visite = [[False]*N for _ in range(M)]
queue = deque()
count = 0
test = 0

for m in range(M):
    temp = input().split(" ")
    for n in range(N):
        ary[m][n] = temp[n]


for m in range(M):
    for n in range(N):
        if ary[m][n] == '1' and not visite[m][n]:
            queue.append((m, n))
            visite[m][n] = True

        while queue:
            now = queue.popleft()
            now_x = now[0]
            now_y = now[1]
            for x, y in dir:
                if (0<= now_x+x < M) and (0 <= now_y+y < N) and ary[now_x+x][now_y+y] == '1' and not visite[now_x+x][now_y+y]:
                    queue.append((now_x+x, now_y+y))
                    visite[now_x+x][now_y+y] = True

            if not queue:
                count+=1

print(count)

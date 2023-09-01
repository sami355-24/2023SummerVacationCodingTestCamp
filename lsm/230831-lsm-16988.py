import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

dir_xs = [0, 1, 0, -1]
dir_ys = [1, 0, -1, 0]
group=[]
ans = 0

N, M = tuple(map(int, input().split(" ")))
board = [list(map(int, input().split())) for _ in range(N)]

def inRange(x, y):
    return 0<= x < N and 0 <= y < M

def bfs(startX, startY):
    board[startX][startY] = 3
    cnt = 0

    q = deque([(startX, startY)])
    empty_spot = set()
    while q:
        x, y = q.popleft()
        cnt += 1

        for dir_x, dir_y in zip(dir_xs, dir_ys):
            nx = x + dir_x
            ny = y + dir_y

            if inRange(nx, ny):
                if (nx, ny) not in empty_spot and board[nx][ny] == 0:
                    empty_spot.add((nx, ny))
                if board[nx][ny] == 2:
                    board[nx][ny] = 3
                    q.append((nx, ny))
    
    if len(empty_spot) <= 2:
        group.append((empty_spot, cnt))

def combi(enemy_stone_count, edges, start):
    global ans

    if len(edges)>2 :
        return
    
    ans = max(ans, enemy_stone_count)

    for i in range(start, len(group)):
        cur_set = set(edges)
        
        for e in group[i][0]:
            cur_set.add(e)
        
        combi(enemy_stone_count+group[i][1], cur_set, i+1)

for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            bfs(i,j)

combi(0, set(), 0)

print(ans)
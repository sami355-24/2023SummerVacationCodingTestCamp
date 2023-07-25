from  collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

dir_r = [-1, 0, 1, 0]
dir_c = [0, 1, 0, -1]

#=========================================================

def BFS(r, c):
    k, v = 0, 0
    queue = deque()
    queue.append([r, c])
    visited[r][c] = True
    
    while queue:
        a, b = queue.popleft()
        if Map[a][b] == 'k': k+=1
        if Map[a][b] == 'v': v+=1

        for i in range(4):
            nr = a + dir_r[i]
            nc = b + dir_c[i]
            if (0 <= nr and nr < R) and (0<= nc and nc < C) and (not visited[nr][nc]) and (Map[nr][nc] != '#'):
                queue.append([nr, nc])
                visited[nr][nc] = True

    if v >= k: k = 0
    else: v = 0
    return[k, v]

#=========================================================
R, C = map(int, input().split(" "))
answer_v, answer_k = 0, 0

Map = [list(input()) for _ in range(R)]
visited = [[False]*C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if Map[i][j] != "#" and not visited[i][j]:
            k, v = BFS(i, j)
            answer_k += k
            answer_v += v

print(answer_k, answer_v)
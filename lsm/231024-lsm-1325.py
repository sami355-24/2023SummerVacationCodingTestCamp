import sys
from collections import deque, defaultdict
input = lambda: sys.stdin.readline().rstrip()

def BFS(start):
    cnt = 1
    q = deque([start])
    visit = [False] * (N+1)
    visit[start] = True
    while q:
        now = q.popleft()
        for key in graph[now].keys():
            if visit[key] == False:
                visit[key] = True
                cnt += 1
                q.append(key)
    
    return cnt

graph = defaultdict(dict)
max_cnt = 0
results = []
N, M = map(int, input().split())

for _ in range(M):
    A, B = map(int, input().split())
    graph[B][A] = 1

for n in range(1, N+1):
    cnt = BFS(n)
    if max_cnt < cnt:
        max_cnt = cnt
    results.append((n, cnt))

for idx, cnt in results:
    if cnt == max_cnt:
        print(idx, end=' ')
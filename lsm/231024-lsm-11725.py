import sys
from collections import deque, defaultdict
input = lambda : sys.stdin.readline().rstrip()

def BFS(now):
    q.append(now)
    visit[now] = True

    while q:
        x = q.popleft()
        for key in graph[x].keys():
            if visit[key] == False:
                visit[key] = True
                q.append(key)
                answer[key] = x

graph = defaultdict(dict)
N = int(input())
visit = [False] * (N+1)
answer = [-1] * (N+1)
q = deque()

for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u][v] = 1
    graph[v][u] = 1

BFS(1)
for value in answer[2:]:
    print(value)
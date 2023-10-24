import sys
from collections import defaultdict, deque
input = lambda : sys.stdin.readline().rstrip()

graph = defaultdict(dict)
q = deque()
answer = 0
N = int(input())
visit = [False] * (N+1)
edge = int(input())
for _ in range(edge):
    u, v = map(int, input().split())
    graph[u][v]=1
    graph[v][u]=1

q.append(1)
visit[1] = True
while q:
    now = q.popleft()
    for edge in graph[now].keys():
        if visit[edge] == False:
            visit[edge] = True
            q.append(edge)
            answer += 1

print(answer)
    
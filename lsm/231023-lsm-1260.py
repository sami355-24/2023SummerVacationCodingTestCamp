import sys
from collections import deque, defaultdict
sys.setrecursionlimit(10**9)
input = lambda: sys.stdin.readline().rstrip()

def DFS(now):
    keys = list(graph[now].keys())
    keys.sort()
    print(now, end = ' ')
    for x in keys:
        if visit[x] == False:
            visit[x] = True
            DFS(x)

def BFS():
    global q
    visit[V] = True
    q.append(V)
    while q:
        now = q.popleft()
        print(now, end=' ')
        keys = list(graph[now].keys())
        keys.sort()
        for x in keys:
            if visit[x] == False:
                visit[x] = True
                q.append(x)

q = deque()
st = list()
graph = defaultdict(dict)
N, M, V = map(int, input().split())
for _ in range(M):
    u, v = map(int, input().split())
    graph[u][v] = 1
    graph[v][u] = 1

visit = [False] * (N+1)
visit[V] = True
DFS(V)
print()
visit = [False] * (N+1)
BFS()
import sys
from collections import deque
input = lambda:sys.stdin.readline().rstrip()

def MakeGraph(N):
    for _ in range(N-1):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

def BFS():
    answer = [-1 for _ in range(N+1)]
    q = deque()
    q.append(1)

    while q:
        parent = q.popleft()
        child = graph[parent]
        for c in child:
            if answer[c] == -1:
                answer[c] = parent
                q.append(c)
    
    return answer

N = int(input())
graph = [[] for _ in range(N+1)]
MakeGraph(N)
answer = BFS()
for x in answer[2:]:
    print(x)
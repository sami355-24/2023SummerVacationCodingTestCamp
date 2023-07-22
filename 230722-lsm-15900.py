import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()


#===================================================
#queue에는 현재 노드, 현재 깊이

def BFS():
    global answer
    queue = deque()
    queue.append([1, 1])

    while queue:
        now, depth = queue.popleft()
        if visited[now] == True:
            continue
        if len(graph[now]) == 1 and now != 1:
            answer += depth -1 

        visited[now] = True

        for i in graph[now]:
            queue.append([i, depth+1])
        

#===================================================

N = int(input())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
answer = 0

for n in range(N-1):
    a, b = map(int, input().split(' '))
    graph[a].append(b)
    graph[b].append(a)

BFS()

if answer % 2 == 0:
    print("No")
else: print("Yes")

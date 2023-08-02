import sys, heapq
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
M = int(input())

visited = [False] * (N+1)
heap = [(0, 1)]
graph = defaultdict(list)
answer = 0

for e in range(M):
    a, b, c = map(int, input().split(" "))
    if (a == b):
        continue
    graph[a].append((c, b))
    graph[b].append((c, a))

while heap:
    c, b = heapq.heappop(heap)
    if visited[b] == False:
        answer += c
        visited[b] = True
        for temp in graph[b]:
            heapq.heappush(heap, temp)

print(answer)
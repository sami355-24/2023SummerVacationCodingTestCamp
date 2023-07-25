import heapq
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline()

V, E = map(int, input().split())
visited = [0]*(V+1)
graph = defaultdict(list)
total_weight = 0
heap = [[0,1]]
answer = 0

for i in range(E):
    a, b, c = map(int, input().split(" "))
    graph[a].append([c, b])
    graph[b].append([c, a])

while heap:

    c, b = heapq.heappop(heap)
    if visited[b] == 0:
        visited[b] = 1
        answer += c
        for temp in graph[b]:
            heapq.heappush(heap, temp)
        
print(answer)
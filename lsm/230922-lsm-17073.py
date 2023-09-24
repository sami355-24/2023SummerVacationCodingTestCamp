import sys
from collections import defaultdict
input = lambda:sys.stdin.readline().rstrip()

graph = defaultdict(int)
N, K = map(int, input().split())
answer = 0

for _ in range(N-1):
    U, V = map(int, input().split())
    graph[U] += 1
    graph[V] += 1

for key in range(2, N+1):
    if graph[key]==1:
        answer += 1

print(K/answer)

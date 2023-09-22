import sys
from collections import defaultdict
input = lambda:sys.stdin.readline()

graph=defaultdict(list)
N = int(input())
for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

q = int(input())
for _ in range(q):
    t, k = map(int, input().split())
    if t == 1:
        if len(graph[k]) < 2:
            print('no')
        else:
            print('yes')
    else:
        print('yes')

import heapq, sys
input=lambda: sys.stdin.readline()


q = []
N = int(input())

for n in range(N):
    x = int(input())
    if x == 0:
        if not q:
            print(0)
        else:
            print(-heapq.heappop(q))
    
    else:
        heapq.heappush(q, -x)
        
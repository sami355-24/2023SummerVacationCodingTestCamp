import sys, heapq
input = lambda: sys.stdin.readline().rstrip()

arr = []
N = int(input())
for n in range(N):
    x = int(input())

    if x == 0:
        if not arr:
            print(0)
        else:
            print(heapq.heappop(arr)[1])
    
    else:
        heapq.heappush(arr, (abs(x), x))
import sys, heapq
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for t in range(T):
    exists = [False]*1000001
    minH, maxH = [], []
    K = int(input())
    for k in range(K):
        cmd, value = input().split(' ')
        value = int(value)

        if cmd == 'I':
            heapq.heappush(minH, (value, k))
            heapq.heappush(maxH, (-value, k))
            exists[k] = True
        
        elif value == 1:
            while maxH and not exists[maxH[0][1]]:
                heapq.heappop(maxH)
            if maxH:
                exists[maxH[0][1]]=False
                heapq.heappop(maxH)
        
        elif value == -1:
            while minH and not exists[minH[0][1]]:
                heapq.heappop(minH)
            if minH:
                exists[minH[0][1]]=False
                heapq.heappop(minH)
    while minH and not exists[minH[0][1]]:
        heapq.heappop(minH)
    while maxH and not exists[maxH[0][1]]:
        heapq.heappop(maxH)
    
    if maxH and minH:
        print(-maxH[0][0], minH[0][0])
    else:
        print('EMPTY')
    
import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

def show(ary):
    for n in range(N):
        for m in range(M):
            print(ary[n][m], end=' ')
        print()

N, M, R = map(int, input().split())
A = [list(input().split()) for _ in range(N)]
answer = [['0']*N for _ in range(N)]

CNT = min(N, M)//2
for cnt in range(CNT):
    deq = deque()
    deq.extend(A[cnt][cnt:M-cnt])
    deq.extend([row[M-cnt-1] for row in A[cnt+1:N-1-cnt]])
    deq.extend(A[N-1-cnt][cnt:M-cnt][::-1])
    deq.extend([row[cnt] for row in A[cnt+1:N-1-cnt]][::-1])

    deq.rotate(-R)

    for i in range(cnt, M-cnt):
        A[cnt][i] = deq.popleft()
    
    for i in range(cnt+1, N-1-cnt):
        A[i][M-cnt-1] = deq.popleft()

    for i in range(M-1-cnt, cnt-1, -1):
        A[N-1-cnt][i] = deq.popleft()

    for i in range(N-2-cnt, cnt, -1):
        A[i][cnt] = deq.popleft()

show(A)
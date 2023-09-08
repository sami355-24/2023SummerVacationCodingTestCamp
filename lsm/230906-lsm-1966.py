from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    q = deque(map(int, input().split(' ')))
    cnt = 0

    while q:
        maxnum = max(q)
        front = q.popleft()
        M -= 1

        if maxnum == front:
            cnt += 1
            if M < 0 :
                print(cnt)
                break
        else:
            q.append(front)
            if M < 0:
                M = len(q) - 1


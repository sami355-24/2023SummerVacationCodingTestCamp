import sys
from collections import deque
input = lambda:sys.stdin.readline().rstrip()

q = deque()
N = int(input())

for n in range(N):
    cmd = input().split(" ")

    if len(cmd) == 2:
        q.append(cmd[1])
    
    elif cmd[0] == 'pop':
        if len(q) > 0:
            print(q.popleft())
        else :
            print(-1)

    elif cmd[0] == 'size':
        print(len(q))

    elif cmd[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    
    elif cmd[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])

    elif cmd[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])

import sys
input = lambda: sys.stdin.readline().rstrip()

st = []
N = int(input())

for idx in range(N):
    cmd = input().split(" ")
    if cmd[0] == 'push':
        st.append(cmd[1])
    
    elif cmd[0] == 'pop':
        if len(st) == 0:
            print(-1)
        else:
            print(st.pop())
    
    elif cmd[0] == 'size':
        print(len(st))

    elif cmd[0] == 'empty':
        if len(st) == 0:
            print(1)
        else:
            print(0)
    
    elif cmd[0] == 'top':
        if len(st) == 0:
            print(-1)
        else:
            print(st[-1])
    
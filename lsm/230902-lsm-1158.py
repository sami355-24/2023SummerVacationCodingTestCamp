import sys
input = lambda:sys.stdin.readline().rstrip()

N, K= map(int, input().split(' '))
ary = [i for i in range(1, N+1)]
answer = []
idx = 0 

for i in range(N):
    idx += K-1
    if idx >= len(ary):
        idx %= len(ary)
    answer.append(str(ary[idx]))
    ary.pop(idx)

print("<", ", ".join(answer), ">", sep="")

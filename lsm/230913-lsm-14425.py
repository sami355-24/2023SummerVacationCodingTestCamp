import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split(' '))
S = set()
answer = 0

for n in range(N):
    S.add(input())

for m in range(M):
    if input() in S:
        answer+=1

print(answer)
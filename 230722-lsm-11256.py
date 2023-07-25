import sys
input = lambda:sys.stdin.readline().rstrip()

T = int(input())
for t in range(T):
    J, N = map(int, input().split(" "))
    data = list()
    answer = 0
    for n in range(N):
        R, C = map(int, input().split(" "))
        data.append(R*C)
    data.sort()
    while J > 0:
        item = data.pop()
        J -= item
        answer += 1

    print(answer)
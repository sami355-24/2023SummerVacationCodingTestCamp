import sys
input = lambda: sys.stdin.readline().split()

N, M, B = map(int, input())
graph = [list(map(int, input())) for _ in range(N)]
answer = sys.maxsize
idx = 0

for target in range(257):
    max_target, min_target = 0, 0

    for n in range(N):
        for m in range(M):
            if graph[n][m] > target:
                max_target += graph[n][m] - target
            else:
                min_target += target - graph[n][m]
    
    if max_target + B >= min_target:
        if min_target + (2* max_target) <= answer:
            idx = target
            answer = min_target + (2* max_target)

print(answer, idx)
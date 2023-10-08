import sys
input = lambda:sys.stdin.readline()

N, M = map(int, input().split())
lights = [-1] + list(map(int, input().split()))
for _ in range(M):
    a, b, c = map(int, input().split())
    if a == 1:
        lights[b] = c
    elif a == 2:
        for idx in range(b, c+1):
            lights[idx] += 1
            lights[idx] %= 2
    elif a == 3:
        for idx in range(b, c+1):
            lights[idx] = 0
    else:
        for idx in range(b, c+1):
            lights[idx] = 1

lights = lights[1:]
for light in lights:
    print(light, end = ' ',)
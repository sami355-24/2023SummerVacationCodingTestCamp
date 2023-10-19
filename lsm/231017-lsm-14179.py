import sys
input = lambda: sys.stdin.readline().rstrip()

H, W = map(int, input().split())
world = list(map(int, input().split()))
water = 0

i = 0
start = -1
while i < len(world):
    if start == -1:
        start = i
    
    elif start != -1 and world[start] <= world[i]:
        for x in range(start, i):
            water += world[start] -  world[x]
        start = -1
        continue

    i += 1


i = len(world)-1
start = -1
while i > -1:
    if start == -1:
        start = i
    
    elif start != -1 and world[start] < world[i]:
        for x in range(start, i, -1):
            water += world[start] -  world[x]
        start = -1
        continue

    i -= 1

print(water)
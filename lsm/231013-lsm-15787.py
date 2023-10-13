import sys
input = sys.stdin.readline
n, m = map(int,input().rstrip().split())

trains = [0 for _ in range(n)]
galaxy = set()

for _ in range(m):
    command = input().rstrip()
    # 태우기
    if command.startswith('1'):
        _, i, x = map(int, command.split())
        i, x = i - 1, x - 1
        temp = 2 ** (19 - x)
        trains[i] = trains[i] | temp
    # 하차
    elif command.startswith('2'):
        _, i, x = map(int, command.split())
        i, x = i - 1, x - 1
        temp = (2 ** 20 - 1) - 2 ** (19 - x)
        trains[i] = trains[i] & temp
    # R-shift
    elif command.startswith('3'):
        _, i = map(int, command.split())
        i = i - 1
        trains[i] = trains[i] >> 1
    # L-shift
    else:
        _, i = map(int, command.split())
        i = i - 1
        trains[i] = trains[i] << 1 & (2 ** 20 - 1)

ans = 0 
for i in range(n):
    train = trains[i]
    if train not in galaxy:
        ans += 1
        galaxy.add(train)

print(ans)
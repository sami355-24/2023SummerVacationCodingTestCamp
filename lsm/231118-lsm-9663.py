import sys
input = lambda:sys.stdin.readline().rstrip()

n = int(input())

ans = 0
row = [0] * n

def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True

def n_Queen(x):
    global ans
    if x == n :
        ans += 1
        return

    else:
        for i in range(n):
            row[x] = i
            if is_promising(x):
                n_Queen(x+1)

n_Queen(0)
print(ans)
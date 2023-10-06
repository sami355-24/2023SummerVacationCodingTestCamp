import sys
input = lambda: sys.stdin.readline().rstrip()

def rotation(ary, n):
    result = [[0]*n for _ in range(n)]

    # 1
    col = (n+1)//2 - 1
    for i in range(n):
        result[i][col] = ary[i][i]

    # 2
    for i in range(n):
        result[i][n-i-1] = ary[i][col]
    
    # 3
    for i in range(n):
        result[col][n-i-1] = ary[i][n-i-1]

    # 4
    for i in range(n):
        result[i][i] = ary[col][i]

    for i in range(n):
        for j in range(n):
            if result[i][j] == 0:
                result[i][j] = ary[i][j]

    return result



def show(ary):
    for i in ary:
        for j in i:
            print(j, end = ' ')
        print()



T = int(input())
for _ in range(T):
    n, d = map(int,input().split())
    ary = [list(input().split()) for _ in range(n)]
    if d < 0:
        d = 360 + d
    
    cnt = d // 45
    for _ in range(cnt):
        ary = rotation(ary, n)
    
    show(ary)
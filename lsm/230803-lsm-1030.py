import sys
input = lambda: sys.stdin.readline().rstrip()



def check_board(l, point):
    x, y = point
    bolck = l//N
    
    if l == 1:
        return 0
    
    if bolck * (N-K)//2 <= x < bolck * (N+K)//2 and bolck * (N-K)//2 <= y < bolck * (N+K)//2:
        return 1
    
    l = l//N
    x %= bolck
    y %= bolck
    return check_board(l, (x,y))

s, N, K, R1, R2, C1, C2 = map(int, input().split())
l = N**s

for r in range(R1, R2+1):
    for c in range(C1, C2+1):
        print(check_board(l, (r, c)), end='')
    print()
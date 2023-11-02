import sys
input = lambda: sys.stdin.readline().rstrip()

def boomb(sec):
    for s in range(sec):
        temp = set()
        # show(s+1)
        for r in range(R):
            for c in range(C):
                # 시간 감소
                if board[r][c] != 0:
                    board[r][c] -= 1 
                
                if s%2 == 1:
                    # 터트릴 폭탄 저장
                    if board[r][c] == 0:
                        # print('\nr:{0} || c:{1}'.format(r, c))
                        for x, y in dir:
                            nr = r + x
                            nc = c + y
                            # print('nr: {0} || nc: {1}'.format(nr, nc))
                            if 0<=nr<R and 0<=nc<C:
                                temp.add((nr, nc))
                
                else:
                    # 폭탄 설치하기
                    if board[r][c] == 0:
                        board[r][c] = 3

        # 폭탄 터트리기
        for x, y in temp:
            board[x][y] = 0

# def show(s):
#     print("\n=========================================")
#     print("{0}초 ".format(s))
#     for r in range(R):
#         print(board[r])

def result():
    for r in range(R):
        for c in range(C):
            if board[r][c] == 0:
                print('.', end='')
            else:
                print('O', end='')
        print()
            
            

R, C, N = map(int, input().split())
board = [[0]*(C) for _ in range(R)]
dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
for r in range(R):
    args = list(input())
    for c, arg in enumerate(args):
        if arg == 'O':
            board[r][c] = 2

boomb(N-1)
result()
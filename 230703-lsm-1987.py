import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
R, C = 0, 0
board = []
answer = -1


def DFS(visited, x, y):
    global answer

    for idx in range(4):
        pos_x = x + dx[idx]
        pos_y = y + dy[idx]
        if (0 <= pos_x < R) and (0<= pos_y < C) and (board[pos_x][pos_y] not in visited):
            visited.add(board[pos_x][pos_y])
            DFS(visited, pos_x, pos_y)
            visited.remove(board[pos_x][pos_y])
        else:
            answer = max(answer, len(visited))

def sol():
    global R, C, board

    R, C = map(int, input().split(" "))
    board = [list(input()[:-1]) for _ in range(R)]
    visited = set()
    visited.add(board[0][0])
    DFS(visited, 0, 0)
    print(answer)
sol()


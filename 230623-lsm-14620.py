#=================== 조합으로 푸는 방법 ===================
# import itertools

# feild = []
# answer = int(10e9)
# d = [(-1, 0), (1, 0), (0, 1), (0, -1)]

# def calc(data):
#     visited = []
#     total = 0
#     global answer 

#     for r, c in data:
#         if (r,c) not in visited:
#             visited.append((r,c))
#             total += feild[r][c]
#             for idx in range(4):
#                 nx = r + d[idx][0]
#                 ny = c + d[idx][1]
#                 if (nx, ny) not in visited:
#                     visited.append((nx, ny))
#                     total += feild[nx][ny]
#                 else: return
#         else: return
    
#     answer = min(answer, total)

# def sol():
#     N = int(input())
    
#     for i in range(N):
#         feild.append(list(map(int, input().split(" "))))

#     candidates = [(r, c) for r in range(1, N-1) for c in range(1, N-1)]

#     for data in itertools.combinations(candidates, 3):
#         calc(data)

#     print(answer)

# sol()

#=================== DFS으로 푸는 방법 =================== 
field = []
answer = int(1e9)
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
N = 0

def sol():
    global N
    N = int(input())
    for _ in range(N):
        field.append(list(map(int, input().split(" "))))
    
    DFS([], 0)

    print(answer)


def DFS(visited, total):
    global answer

    if total >= answer:
        return

    if len(visited) == 15:
        answer = min(answer, total)

    else:
        for i in range(1, N-1):
            for j in range(1, N-1):
                if check(i, j, visited) and (i,j) not in visited:
                    temp = [(i,j)]
                    temp_cost = field[i][j]
                    for idx in range(4):
                        nx = i + d[idx][0]
                        ny = j + d[idx][1]
                        temp.append((nx, ny))
                        temp_cost += field[nx][ny]
                    DFS(visited + temp, total + temp_cost)


def check(i, j, visited):
    for idx in range(4):
        nx = i + d[idx][0]
        ny = j + d[idx][1]
        if (nx, ny) in visited: return False

    return True

sol()
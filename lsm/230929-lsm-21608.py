import sys
input = lambda: sys.stdin.readline().rstrip()

def condition1(friends):
    global dir, seat, N
    positions = []
    max_count = -1

    for x in range(1, N+1):
        for y in range(1, N+1):
            if seat[x][y] == 0:
                now_count = 0
                for dir_x, dir_y in dir:
                    if (0< x+dir_x <N+1) and (0< y+dir_y <N+1) and seat[x+dir_x][y+dir_y] in friends:
                        now_count += 1
                if now_count == max_count:
                    positions.append([x, y])
                elif now_count > max_count:
                    positions.clear()
                    max_count = now_count
                    positions.append([x, y])
        
    return positions

def condition2(candidate):
    global dir, seat, N
    positions=[]
    max_count = -1
    for x, y in candidate:
        now_count = 0
        for dir_x, dir_y in dir:
            if (0< x+dir_x <N+1) and (0< y+dir_y <N+1) and seat[x+dir_x][y+dir_y] == 0 and seat[x][y] == 0:
                now_count+=1
        if now_count == max_count:
            positions.append([x, y])
        if now_count > max_count:
            positions.clear()
            max_count = now_count
            positions.append([x, y])
    return positions

def condition3(candidate):
    return min(candidate)
        

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
answer = 0
satisfaction = {0:0, 1:1, 2:10, 3:100, 4:1000}
info = dict()
N = int(input())
seat = [[0]*(N+2) for _ in range(N+2)]
for _ in range(N**2):
    args = list(map(int, input().split()))

    student = args[0]
    friends = args[1:]
    info[student]=friends

    positions = condition1(friends)
    if len(positions) == 1:
        position = positions[0]
        seat[position[0]][position[1]] = student
    else:
        positions = condition2(positions)
        if len(positions) == 1:
            position = positions[0]
            seat[position[0]][position[1]] = student
        else:
            position = condition3(positions)
            seat[position[0]][position[1]] = student

for x in range(1,N+1):
    for y in range(1,N+1):
        student = seat[x][y]
        friends = info[student]
        temp = 0
        for dir_x, dir_y in dir:
            if (0< x+dir_x <N+1) and (0< y+dir_y <N+1) and seat[x+dir_x][y+dir_y] in friends:
                temp += 1
        answer += satisfaction[temp]

print(answer)
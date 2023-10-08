N = int(input())
number = int(input())
ary=  [[-1]*N for _ in range(N)]

def show(ary):
    for X in ary:
        for x in X:
            print(x, end=' ')
        print('')

dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]
d = 0
pos_x, pos_y = 0, 0

answer = (1, 1)
value = N**2
ary[0][0] = value
value -= 1


while True:
    dir_x, dir_y = dir[d][0], dir[d][1]    
    while (0 <= pos_x + dir_x < N) and (0 <= pos_y + dir_y < N) and ary[pos_x + dir_x][pos_y + dir_y] == -1:
        ary[pos_x + dir_x][pos_y + dir_y] = value
        value -= 1
        pos_x += dir_x
        pos_y += dir_y

        if value+1 == number:
            answer = (pos_x+1, pos_y+1)
        
        # input()
        # show(ary)
        # print(answer)

    d += 1
    d %= 4

    if value == 0 :
        break


show(ary)
print(answer[0], answer[1])
import sys
input = lambda:sys.stdin.readline().rstrip()

n = int(input())
x = 0
st = [x]
answer = []

for _ in range(n):
    num = int(input())
    flag = False

    while st[-1] < num and x < num:
        x += 1
        st.append(x)
        answer.append('+')
        flag = True

    while st[-1] >= num:
        temp = st.pop()
        answer.append('-')
        flag = True

    if not flag:
        print('NO')
        exit()

print('\n'.join(answer))

datas = input().rstrip()

answer = 0
pipes = 0

for idx, data in enumerate(datas):
    if data == '(' :
        pipes += 1
        answer += 1

    if data == ')' and datas[idx-1] == '(':
        pipes -= 1
        answer -= 1
        answer += pipes

    if data == ')' and datas[idx-1] == ')':
        pipes -= 1

print(answer)
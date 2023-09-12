import sys
input = lambda:sys.stdin.readline()

N, M = map(int, input().split(' '))
dict_num = dict()
dict_name = dict()

i = 1
for n in range(N):
    name = input().rstrip()
    dict_num[i] = name
    dict_name[name] = i
    i+=1


for m in range(M):
    question = input().rstrip()
    if question.isnumeric():
        print(dict_num[int(question)])
    else:
        print(dict_name[question])


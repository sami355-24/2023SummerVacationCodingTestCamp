import itertools

left_bracket = []
right_bracket = []
bracket = []
candidate = []
answer = []
st = []

datas = input().rstrip()

for idx, data in enumerate(datas):
    if data == '(':
        st.append(idx)
    elif data == ')':
        x = st.pop()
        y = idx
        bracket.append((x, y))

for i in range(1, len(bracket)+1):
    for x in itertools.combinations(bracket, i):
        candidate.append(x)

for c_tuple in candidate:
    temp = [True for _ in range(len(datas))]
    for x, y in c_tuple:
        temp[x] = False
        temp[y] = False
    
    answer.append(''.join([datas[i] for i in range(len(datas)) if  temp[i] == True]))

answer = list(set(answer) )
answer.sort()
for i in range(len(answer)):
    print(answer[i])
import sys
input = lambda: sys.stdin.readline().rstrip()

dictionary = dict()
N = int(input())
datas = input()
flag = False
st = list()
answer = 0

for n in range(N):
    dictionary[chr(ord('A') + n)] = int(input())

for d in datas:
    if d.isalpha():
        st.append(dictionary[d])

    else:
        y = st.pop()
        x = st.pop()
        temp = 0

        if d == '+':
            temp = x + y
        elif d == '-':
            temp = x - y
        elif d == '*':
            temp = x * y
        elif d == '/':
            temp = x/y
        st.append(temp)
        answer = temp
    
print('{0:.2f}'.format(answer))
import sys
input = sys.stdin.readline

N, K = map(int, input().split(" "))
datas = input().rstrip()

idx = 0
st = []
for data in datas:
    while st and st[-1] < data and K > 0:
        st.pop()
        K -= 1
    st.append(data) 
    

if K > 0:
    st = st[:-K]

print(''.join(st))

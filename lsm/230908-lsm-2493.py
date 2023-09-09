N = int(input())
heights = list(map(int, input().split(' ')))
answer = []
st=[] # idx, h

for idx, h in enumerate(heights):
    while st and st[-1][1] <= h:
        st.pop()

    if st and st[-1][1] > h:
        answer.append(str(st[-1][0]+1))

    else:
        answer.append('0')

    st.append((idx, h))


print(' '.join(answer))
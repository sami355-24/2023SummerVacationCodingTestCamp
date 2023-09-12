import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
circles = []

for i in range(N):
    x, r = map(int, input().split())
    circles.append((x-r, i))
    circles.append((x+r, i))

circles.sort()
st = []

for c in circles:
    if st:
        if st[-1][1] == c[1]:
            st.pop()
        else:
            st.append(c)
    else:
        st.append(c)

if st:
    print("NO")

else:
    print("YES")
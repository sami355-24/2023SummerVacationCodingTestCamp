import sys
input = lambda: sys.stdin.readline().rstrip()

T = int(input())

for t in range(T):
    st = []
    test_data = input()
    for x in test_data:
        if x == ')' and len(st) > 0 and st[-1] == '(':
            st.pop()
        else:
            st.append(x)
    
    if len(st) == 0:
        print("YES")
    else:
        print("NO")
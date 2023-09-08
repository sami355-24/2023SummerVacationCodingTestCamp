bracket=list(input())

st = []
answer = 0
temp = 1

for i in range(len(bracket)):

    if bracket[i] == '(':
        st.append('(')
        temp *= 2
    
    elif bracket[i] == '[':
        st.append('[')
        temp *= 3
    
    elif bracket[i] == ')':
        if  not st or st[-1] == '[':
            print(0)
            exit()
        
        elif bracket[i-1] == '(':
            answer += temp

        st.pop()
        temp //= 2
    
    elif bracket[i] == ']':
        if not st or st[-1] == '(':
            print(0)
            exit()
        
        elif bracket[i-1] == '[':
            answer += temp
        
        temp //= 3
        st.pop()

if st:
    print(0)

else:
    print(answer)
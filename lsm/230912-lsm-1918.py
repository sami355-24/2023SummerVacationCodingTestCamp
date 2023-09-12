infix = list(input())
st = []
result = ''

for c in infix:
    if c.isalpha():
        result += c
    
    else:
        if c == '(':
            st.append(c)
        
        elif c == '*' or c == '/':
            while st and (st[-1] == '*' or st[-1] == '/'):
                result += st.pop()
            st.append(c)
        
        elif c == '+' or c == '-':
            while st and st[-1] != '(':
                result += st.pop()
            st.append(c)
        
        elif c == ')':
            while st and st[-1] != '(':
                result += st.pop()
            st.pop()

while st:
    result += st.pop()

print(result)
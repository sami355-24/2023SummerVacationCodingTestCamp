import sys

st=[]
string = sys.stdin.readline().rstrip()
start, end = 0, 0

while start < len(string):
    if string[start] == '<':
        if st:
            word = ''.join(st)
            st.clear()
            print(word[::-1], end = '')

        while string[start]!= '>':
            print(string[start], end = '')
            start += 1
        print(string[start], end = '')
        start+=1
    
    elif string[start] == ' ':
        word = ''.join(st)
        st.clear()
        print(word[::-1], end = ' ')
        start += 1
    
    else:
        st.append(string[start])
        start+=1

if st:
    word = ''.join(st)
    st.clear()
    print(word[::-1], end = '')
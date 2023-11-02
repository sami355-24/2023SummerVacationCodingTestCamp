a,b,c = map(int, input().split())

if a==b==c:
    print(10000 + a*1000)

elif not a==b==c and a==b or a==c:
    print(1000 + a*100)
elif not a==b==c and b==c:
    print(1000 + b*100)

if a!=b and a!=c and b!=c:
    max_num = max([a,b,c])
    print(max_num*100)
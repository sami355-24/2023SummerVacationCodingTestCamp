total = int(input())
types = int(input())
sum = 0

for i in range(types):
    price, count = map(int, input().split())
    sum += price*count

if sum==total:
    print("Yes")
else:
    print("No")
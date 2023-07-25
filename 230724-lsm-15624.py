import sys
input = lambda:sys.stdin.readline()

a= 0
b= 1
n = int(input())

for i in range(n):
    a, b = (a+b)%1000000007, a%1000000007


print(a)
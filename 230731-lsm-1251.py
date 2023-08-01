import sys

input = lambda:sys.stdin.readline().rstrip()
word = input()
temp = []

for i in range(1, len(word)-1):
    for j in range(i+1, len(word)):
        a = word[:i]
        b = word[i:j]
        c = word[j:]
        temp.append(a[::-1] + b[::-1] + c[::-1])

print(sorted(temp)[0])
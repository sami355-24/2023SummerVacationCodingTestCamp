from sys import stdin
input = lambda:stdin.readline().rstrip()

dictionary = dict()
N = int(input())
for _ in range(N):
    word = input()
    point_pos = word.find('.')
    postfix = word[point_pos+1:]
    if postfix in dictionary:
        dictionary[postfix]+=1
    else:
        dictionary[postfix]=1

result = list(dictionary.items())
for key, value in sorted(result):
    print(key, value)

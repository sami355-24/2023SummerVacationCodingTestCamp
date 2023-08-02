import sys, itertools
input = lambda: sys.stdin.readline().rstrip()

L, C = map(int, input().split(" "))
characters = list(input().split(" "))

x = set(['a', 'e', 'i', 'o', 'u'])
y = set(['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'])
answer = []

for data in itertools.combinations(characters, L):
    data = set(data)
    countOfX = len(data.intersection(x))
    countOfY = len(data.intersection(y))

    if countOfX >= 1 and countOfY >= 2:
        answer.append(sorted(data))

answer.sort()

for data in answer:
    print("".join(data))
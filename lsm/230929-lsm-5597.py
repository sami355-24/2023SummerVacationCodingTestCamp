students = set([i for i in range(1, 31)])
args = set()
for _ in range(28):
    args.add(int(input()))

diff = students - args
print(min(diff))
print(max(diff))
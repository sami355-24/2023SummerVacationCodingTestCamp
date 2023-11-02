h, m = map(int, input().split())
time = int(input())

res_h = h+((m+time)//60)
if res_h > 23:
    print(f"{res_h-24} {(time+m)%60}")
else:
    print(f"{res_h} {(time+m)%60}")
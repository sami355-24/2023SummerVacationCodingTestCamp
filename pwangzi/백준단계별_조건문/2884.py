h,m = map(int, input().split())

if m-45<0:
    if h-1 >= 0:
        print(f"{h-1} {60-(45-m)}")
    else:
        print(f"23 {60-(45-m)}")

else:
    print(f"{h} {m-45}")
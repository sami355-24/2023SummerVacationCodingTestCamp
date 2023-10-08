def check_leaf_year(year):
    if year % 4 == 0:
        if year % 100 != 0:
            return True
        elif year % 400 == 0:
            return True
    return False

result = check_leaf_year(int(input()))
if result:
    print(1)
else:
    print(0)
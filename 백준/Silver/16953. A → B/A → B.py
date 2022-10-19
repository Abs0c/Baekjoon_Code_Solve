import sys
input = sys.stdin.readline

a ,b = map(int, input().split())
ind = 1

while b > a:
    if b % 2 == 0:
        b = b / 2
        ind += 1
    elif b % 2 == 1:
        b = (b - 1) / 10
        ind += 1
    else:
        break

if b == a:
    print(ind)
else:
    print(-1)
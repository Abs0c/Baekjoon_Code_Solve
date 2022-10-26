import collections
import sys
input = sys.stdin.readline

n = int(input())
arr = collections.defaultdict(list)
dayarr = []

for i in range(n):
    a, b = map(int, input().split())
    arr[a].append(b)
    if a not in dayarr:
        dayarr.append(a)

dayarr.sort(key = lambda x : x, reverse = True)
temp = []
cnt = 0
for i in range(dayarr[0], 0, -1):
    temp += arr[i]
    if len(temp) <= 0:
        continue
    a = max(temp)
    cnt += a
    del temp[temp.index(a)]

print(cnt)

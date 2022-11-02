import sys
input = sys.stdin.readline

def get_parent(parent, x):
    if parent[x] != x:
        parent[x] = get_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a_parent = get_parent(parent, a)
    b_parent = get_parent(parent, b)
    if a_parent < b_parent:
        parent[b_parent] = a_parent
    else:
        parent[a_parent] = b_parent

n, m = map(int, input().split())
arr = []
for i in range(m+1):
    arr.append(list(map(int, input().split())))    

parent = [0] * (n+1)

for i in range(n+1):
    parent[i] = i
arr.sort(key = lambda x : x[2], reverse=True)
summin = 0
for ed in arr:
    a, b, c = ed
    if get_parent(parent, a) != get_parent(parent, b):
        union_parent(parent, a, b)
        if c == 0:
            summin += 1
        
for i in range(n+1):
    parent[i] = i
summax = 0

for ednum in range(m, -1, -1):
    a, b, c = arr[ednum]
    if get_parent(parent, a) != get_parent(parent, b):
        union_parent(parent, a, b)
        if c == 0:
            summax += 1

print(summax*summax - summin*summin)

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

while True:
    m, n = map(int, input().split())
    if m == 0 and n == 0:
        break
    parent = [0] * (m)
    for i in range(m):
        parent[i] = i
    arr = []
    summ = 0
    for i in range(n):
        a, b, c = map(int, input().split())
        arr.append([a, b, c])
        summ += c

    arr.sort(key = lambda x : x[2])

    for ed in arr:
        a, b, c = ed
        if get_parent(parent, a) != get_parent(parent, b):
            union_parent(parent, a, b)
            summ -= c
    print(summ)

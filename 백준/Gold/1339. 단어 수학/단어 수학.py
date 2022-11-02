import collections

n = int(input())
arr = []
key = [0] * 26
mapt = []
mathval = collections.defaultdict(list)

for i in range(n):
    arr.append(input())

for i in arr:
    for j in range(len(i)):
        key[ord(i[j]) % ord("A")] += (10**(len(i)-j))

for i in range(len(key)):
    mapt.append([key[i], chr(i+65)])

mapt.sort(key = lambda x : x[0], reverse=True)
temp = 9
for i in mapt:
    mathval[i[1]] = temp
    temp -= 1

summ = 0
for i in arr:
    temp = 0
    for j in range(len(i)):
        temp *= 10
        temp += mathval[i[j]]
    summ += temp

print(summ)

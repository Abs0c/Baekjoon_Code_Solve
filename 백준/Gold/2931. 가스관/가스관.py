import collections
import sys
input = sys.stdin.readline

r,c = map(int, input().split())
arr = []
go = [[-1, 0], [0, -1], [1, 0], [0, 1]] #위 왼쪽 아래 오른쪽
typearr = ["|", "-", "+", "1", "2", "3", "4"]
typegoarr = [[[-1, 0], [1, 0]], [[0, -1], [0, 1]], [[-1, 0],[0, -1],[0, 1],[1, 0]], [[1, 0], [0, 1]], [[-1, 0], [0, 1]], [[-1, 0], [0, -1]], [[0, -1], [1, 0]]]
mr = 0
mc = 0
ansr = 0
ansc = 0

for i in range(r):
    temp = input()
    if "M" in temp:
        mr = i
        mc = temp.index("M")
    arr.append(temp)

breakp = False
for a in range(r):
    if breakp == True:
        break
    for b in range(c):
        if arr[a][b] != "." and arr[a][b] != "M" and arr[a][b] != "Z":
            tyind = typearr.index(arr[a][b])
            for tygoind in typegoarr[tyind]:
                ta = a + tygoind[0]
                tb = b + tygoind[1]
                if 0 <= ta < r and 0 <= tb < c:
                    if arr[ta][tb] == ".":
                        ansr = ta
                        ansc = tb
                        breakp = True
                        break
anst = ""
temp = []
for i in range(4):
    tempr = ansr + go[i][0]
    tempc = ansc + go[i][1]
    if 0 <= tempr < r and 0 <= tempc < c:
        if i == 0 and (arr[tempr][tempc] == typearr[0] or arr[tempr][tempc] == typearr[2] or arr[tempr][tempc] == typearr[3] or arr[tempr][tempc] == typearr[6]):
            temp.append(i)
        elif i == 1 and (arr[tempr][tempc] == typearr[1] or arr[tempr][tempc] == typearr[2] or arr[tempr][tempc] == typearr[3] or arr[tempr][tempc] == typearr[4]):
            temp.append(i)
        elif i == 2 and (arr[tempr][tempc] == typearr[0] or arr[tempr][tempc] == typearr[2] or arr[tempr][tempc] == typearr[4] or arr[tempr][tempc] == typearr[5]):
            temp.append(i)
        elif i == 3 and (arr[tempr][tempc] == typearr[1] or arr[tempr][tempc] == typearr[2] or arr[tempr][tempc] == typearr[5] or arr[tempr][tempc] == typearr[6]):
            temp.append(i)          

if len(temp) == 4:
    anst = "+"
elif temp[0] == 0 and temp[1] == 2:
    anst = "|"
elif temp[0] == 1 and temp[1] == 3:
    anst = "-"
elif temp[0] == 2 and temp[1] == 3:
    anst = "1"
elif temp[0] == 0 and temp[1] == 3:
    anst = "2"
elif temp[0] == 0 and temp[1] == 1:
    anst = "3"
elif temp[0] == 1 and temp[1] == 2:
    anst = "4"
print(ansr+1, ansc+1, anst)
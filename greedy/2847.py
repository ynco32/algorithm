# 백준 2847 게임을 만든 동준이

n = int(input())
data = [i for i in range(n)]
for i in range(n):
  #print(i)
  data[i] = int(input())

# print("------")
# print(data)

last = data[n - 1]

for i in range(n):
  data[i] = data[i] - last

#print("------")
#print(data)

cnt = 0

for i in range(n - 2, 0, -1):
  if data[i] >= data[i + 1]:
    cnt = cnt + (data[i] - data[i + 1]) + 1
    data[i] = data[i + 1] - 1

print(cnt)

# 백준 1439 뒤집기

data = input()
cnt = 0
zero = 0
one = 0
tmp = -1

for i in range(len(data)):
  if (tmp != data[i]):
    tmp = data[i]
    if (tmp == '0'):
      zero += 1
    else:
      one += 1 

if (zero > one):
  print(one)
else:
  print(zero)



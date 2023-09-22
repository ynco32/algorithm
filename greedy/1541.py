# 백준 1541 잃어버린 괄호

data = input()

num = data.split("-")
added_num = []

for i in num:
  #print(i)
  sum = 0
  tmp_list = i.split("+")
  for j in tmp_list:
    #print(j)
    sum += int(j)
  added_num.append(sum)

#print(added_num)

n = added_num[0]

for i in range (1,len(added_num)):
  #print(added_num[i])
  n -= added_num[i]

print(n)
# 백준 11501 주식

T = int(input())

for _ in range (T):
  N = int(input())
  day = input().split()
  tmp = int( day[len(day)-1] )

  num = 0
  cnt = 0
  
  for i in range(len(day)-2, -1, -1):
    if (int(day[i]) > tmp):
      #print(cnt)
      num += cnt * tmp
      tmp = int(day[i])
      cnt = 0
    else:
      # print("else")
      # print(int(day[i]))
      num -= int(day[i])
      cnt += 1

  num += cnt * tmp
  
  if (num < 0):
    print(0)
  else:
    print(num)

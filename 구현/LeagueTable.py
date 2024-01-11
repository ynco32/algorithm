#programmers
#예상 대진표



def solution(n,a,b):
    answer = 0
    
    cnt = 0
    m = n
    
    while m>0:
        m=m//2
        cnt+=1
    
    cnt -=1
    print(cnt)
    
    while (n > 0):
        n= n//2
        if (a > n and b > n):
            a -= n
            b -= n
            cnt -= 1
            
        elif a <= n and b <= n:
            cnt -=1
            
        else:
            answer = cnt
            break
            


    return answer
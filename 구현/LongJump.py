#프로그래머스
#멀리뛰기

def solution(n):
    list = [0] * 2001
    answer = 0 
    list[1] = 1
    list[2] = 2
    
    
    for i in range(3,n+1):
        list[i] = list[i-1] + list[i-2]
    
    answer = list[n] % 1234567
    
    return answer
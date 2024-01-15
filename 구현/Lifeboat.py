
# Programmers
# 구명보트


##### ERROR ######


def solution(people, limit):
    answer = 0
    people.sort()
    one = 0
    idx = len(people)-1
    for i in range (len(people)):
        if idx > i:
            if people[i] >= limit:
                answer+=1
            else:
                if people[idx]+people[i] > limit:
                    answer+=1
                else:
                    #answer+=1
                    idx -= 1
        elif idx == i:
            answer+=1
             
                
    if one>0:
        answer+=1
        
    
    return answer
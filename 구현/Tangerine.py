#Programmers
#귤 고르기

### ERROR ####



def solution(k, tangerine):
    tangerine.sort();
    #print(tangerine)
    multi = []
    last = -1
    answer = 0
    
    for t in tangerine:
        if last == t:
            #tangerine.remove(t)
            if t not in multi:
                multi.append(t)
        else:
            last = t
            
    updated = [t for t in tangerine if t not in multi]
    cnt = [tangerine.count(t) for t in multi]
    #print(multi)
    #print(cnt)
    all =0
    while k > 0:
        if cnt:
            k -= max(cnt)
            all += max(cnt)
            multi.remove(multi[cnt.index(max(cnt))])
            answer += 1
        else:
            break
    
    if k > 0:
        answer += k
    
    return answer
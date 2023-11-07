#Lv 2. JadenCase 문자열 만들기

def solution(s):
    answer = ''
    words = s.split(" ")
    l = len(words)
    for i in range(l):
        temp = words[i]
        if (temp == " " or temp == ""):
            answer+= " "
            
        if (temp != " " and temp != ""):
            if (temp[0].isdigit()):
                answer = answer + temp[0]
                
            else:
                answer = answer + temp[0].upper()
            answer = answer + temp[1:].lower()
            answer = answer + " "
        else:
            answer = answer + ""
    answer = answer[:-1]
    return answer

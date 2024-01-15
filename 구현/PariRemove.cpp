#include <iostream>
#include<string>
using namespace std;

//Programmers
//짝지어 제거하기

// ERROR // 


int solution(string s)
{
    int answer = -1;

    
    
    while (s.length() > 2){
        int len = s.length();
        char last = s[0];
        for (int i = 1; i < len; i++){
			if (last == s[i]){
                s.erase(i-1,i);
                i++;
                last = s[i];
                
            }
            else {
                last = s[i];
            }

            
        }
	}
    
    if (s.length() == 1) answer = 1;
	else answer = 0;

    return answer;
}
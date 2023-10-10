//
//  main.cpp
//  2457-2
//
//  Created by Yunji Choe on 10/10/23.
//

#include <iostream>
#include <algorithm>
#include <deque>


using namespace std;

typedef struct flowers{
    int b_month;
    int b_day;
    int d_month;
    int d_day;
} flower;

//bool compare(flower a, flower b){
//    
//    if (a.b_month == b.b_month){
//        if (a.b_day == b.b_day){
//            if (a.d_month == b.d_month){
//                return a.d_day > b.d_day;
//            }
//            return a.d_month > b.d_month;
//        }
//        
//        else return a.b_day < b.b_day;
//    }
//    else return a.b_month < b.b_month;
//    
//}

bool compare2(flower a, flower b){
    
    if (a.d_month == b.d_month){
        if (a.d_day == b.d_day){
            if (a.b_month == b.b_month){
                return a.b_day < b.b_day;
            }
            return a.b_month < b.b_month;
        }
        
        else return a.d_day > b.d_day;
    }
    else return a.d_month > b.d_month;
    
}



//날짜가 a < b 일때 (a가 b보다 이른 날짜)
bool compare_b(flower a, flower b){
    
    if (a.b_month == b.b_month){
        return a.b_day < b.b_day;
    }
    else return a.b_month < b.b_month;
    
}




bool compare_d(flower a, flower b){
    if (a.d_month == b.d_month){
        return a.d_day < b.d_day;
    }
    return a.d_month < b.d_month;

}

bool compare_d_b(flower a, flower b){
    if (a.d_month == b.b_month){
        return a.d_day < b.b_day;
    }
    return a.d_month < b.b_month;

}


int main(int argc, const char * argv[]) {
    int N;
    int cnt = 1;
    vector<flower> list;

    flower princess;
    princess.b_day = 1;
    princess.b_month = 3;
    princess.d_day = 30;
    princess.d_month = 11;
    
    cin >> N;
    
    for (int i = 0; i< N; i++){
        
        flower temp;
        
        cin >> temp.b_month >> temp.b_day >> temp.d_month >> temp.d_day;
        list.push_back(temp);
            
    }
    

    
    sort(list.begin(), list.end(), compare2);
    
//    printf("\n");
//    for (int i = 0; i< N; i++){
//        cout << list[i].b_month<<" " << list[i].b_day<<" " << list[i].d_month<<" " << list[i].d_day<<endl;
//    }
//    cout << endl;
    int index = 0;
    flower first = list[0];
    for (int i = 0 ; i< N;i++){
        //12/1일보다 일찍 지는 날짜 찾기
        //princess < list[i]
        if (compare_d(list[i], princess)){
            index = i;
            break;
        }
        else {
            if (compare_b( list[i],first)){
                first = list[i];
            }
        }
    }
    
    flower last = first;
    
    //cout << first.d_month << " " << first.d_day;
    bool result = false;
    for (int i = index; i < N; i++){
        if (compare_b(princess, first)){
            if (!compare_d_b(list[i], first)){
                
                if (i < N-1){
                    if (!compare_d_b(list[i+1],first)){
                        continue;
                    }
                    else {
                        first = list[i];
                        //cout << i << " " << first.b_month << " " << first.b_day << " " << first.d_month << " " << first.d_day<<endl;
                        cnt++;
                    }
                }
                else {
                    first = list[i];
                    //cout << i << " " << first.b_month << " " << first.b_day << " " << first.d_month << " " << first.d_day<<endl;
                    cnt++;
                }
            }
        }
    }
    
    
    // !(3/1 < first) ||
    if (compare_b(princess, first) || !compare_d(princess, last)) cout << 0;
    else cout << cnt;
    return 0;
}

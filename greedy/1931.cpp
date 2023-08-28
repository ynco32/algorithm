
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    int n;
    int a, b;
    vector <pair<int,int>> v;
    
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> a >> b;
        v.push_back(pair<int,int>(b,a));
    }
    
    sort(v.begin(), v.end());
    
    int cnt = 0;
    int last = 0;
    
    for (int i = 0; i < n; i++){
        if (last <= v[i].second){
            last = v[i].first;
            cnt++;
        }
    }
    
    cout << cnt;
    return 0;
}

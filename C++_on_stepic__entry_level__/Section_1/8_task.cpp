#include <iostream>

using namespace std;

int main()
{
    int a;
    cin>>a;
    for(int i = 0; i < a; i++){
        int x(1),b,count(0);
        cin>>b;
        while(x<=b){
            x*=2;
            count++;
        }
        cout<<--count<<endl;
    }
    return 0;
}


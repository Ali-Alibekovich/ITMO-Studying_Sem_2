#include <iostream>
using namespace std;

int main()
{
    char c = '\0';
    bool x (false);
    while (cin.get(c)) {
        if(c==' '){
            x=true;
            continue;
        }else {
            if(x){
                cout<<' ';
                x= false;
            }
            cout<<c;
        }
    }
    return 0;
}